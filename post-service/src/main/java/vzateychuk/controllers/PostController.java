package vzateychuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vzateychuk.dto.PostDto;
import vzateychuk.exceptions.EntityAlreadyExistsException;
import vzateychuk.exceptions.NotFoundEntityException;
import vzateychuk.map.Mapper;
import vzateychuk.model.PostEntity;
import vzateychuk.repo.PostRepo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired private PostRepo PostRepo;
    @Autowired private Mapper<PostEntity, PostDto> mapper;

    @GetMapping("/")
    public List<PostDto> findAll() {

        return PostRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostEntity findOne(@PathVariable Long id) {

        return PostRepo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundEntityException("PostId: " + id + " not found")
                );
    }

    @PostMapping("/")
    public PostDto create(@RequestBody PostDto dto) {

        if (dto.getId() != null && PostRepo.findById(dto.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("PostId: " + dto.getId() + " already exists");
        }
        PostEntity entity = mapper.toEntity(dto);
        return mapper.toDto(PostRepo.save(entity));
    }

    @PutMapping("/")
    public PostDto update(@RequestBody PostDto dto) {

        if (dto.getId() == null) {
            throw new NotFoundEntityException("PostId cant be empty");
        }
        PostEntity entity = mapper.toEntity(dto);
        return mapper.toDto(PostRepo.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        if (id == null) {
            throw new NotFoundEntityException("PostId cant be empty");
        }

        PostRepo.deleteById(id);
    }

}
