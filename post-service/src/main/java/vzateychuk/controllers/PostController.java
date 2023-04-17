package vzateychuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vzateychuk.dto.PostDto;
import vzateychuk.exceptions.EntityAlreadyExistsException;
import vzateychuk.exceptions.NotFoundEntityException;
import vzateychuk.map.Mapper;
import vzateychuk.model.PostEntity;
import vzateychuk.service.PostService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired private PostService postService;
    @Autowired private Mapper<PostEntity, PostDto> mapper;

    @GetMapping("/")
    public List<PostDto> findAll() {

        return postService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostEntity findOne(@PathVariable Long id) {

        return postService
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundEntityException("PostId: " + id + " not found")
                );
    }

    @PostMapping("/")
    public PostDto create(@RequestBody PostDto dto) {

        if (dto.getId() != null && postService.findById(dto.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("PostId: " + dto.getId() + " already exists");
        }
        PostEntity entity = mapper.toEntity(dto);
        entity.setPostedAt(LocalDate.now());
        return mapper.toDto(postService.save(entity));
    }

    @PutMapping("/")
    public PostDto update(@RequestBody PostDto dto) {

        if (dto.getId() == null) {
            throw new NotFoundEntityException("PostId cant be empty");
        } else if (postService.findById(dto.getId()).isEmpty()) {
            throw new NotFoundEntityException("PostId: " + dto.getId() + " not found");
        }
        PostEntity entity = mapper.toEntity(dto);
        entity.setPostedAt(LocalDate.now());
        return mapper.toDto(postService.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        if (id == null) {
            throw new NotFoundEntityException("PostId cant be empty");
        }

        postService.deleteById(id);
    }

}
