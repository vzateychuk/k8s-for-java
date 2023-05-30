package vzateychuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vzateychuk.dto.UserDto;
import vzateychuk.exceptions.NotFoundEntityException;
import vzateychuk.exceptions.UnableUpdateUserException;
import vzateychuk.model.PostEntity;
import vzateychuk.repo.PostRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired private PostRepo repo;
    @Autowired private RestTemplate restTemplate;
    @Value("${user.service.api}") private String userAPI;

    @Override
    public List<PostEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public PostEntity save(PostEntity post) {
        // lookup for the author and update some author data
        try {
            updateAmountOfPostsForUser(post);
        } catch (Exception ex) {
            throw new UnableUpdateUserException("Unable update author: " + ex);
        }
        return repo.save(post);
    }

    private void updateAmountOfPostsForUser(PostEntity post) {

        UserDto userDto = restTemplate.getForObject(userAPI + "/users/" + post.getAuthorId() , UserDto.class);
        if (userDto == null) {
            throw new NotFoundEntityException("AuthorId: " + post.getAuthorId() + " not found");
        }
        int posts = userDto.getAmountOfPosts();
        userDto.setAmountOfPosts(posts + 1);

        HttpEntity<UserDto> putReq = new HttpEntity<>(userDto);
        ResponseEntity<UserDto> resp = restTemplate.exchange(userAPI, HttpMethod.PUT, putReq, UserDto.class);
        if (resp.getStatusCode() != HttpStatus.OK) {
            throw new UnableUpdateUserException("Response code: " + resp.getStatusCode());
        }
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
