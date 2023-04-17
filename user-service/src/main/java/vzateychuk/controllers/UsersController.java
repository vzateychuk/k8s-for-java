package vzateychuk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vzateychuk.dto.UserDto;
import vzateychuk.exceptions.EntityAlreadyExistsException;
import vzateychuk.exceptions.NotFoundEntityException;
import vzateychuk.map.Mapper;
import vzateychuk.model.UserEntity;
import vzateychuk.repo.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired private UserRepo userRepo;
    @Autowired private Mapper<UserEntity, UserDto> mapper;

    @GetMapping("/")
    public List<UserDto> findAll() {

        return userRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserEntity findOne(@PathVariable Long id) {

        return userRepo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundEntityException("userId: " + id + " not found")
                );
    }

    @PostMapping("/")
    public UserDto create(@RequestBody UserDto dto) {

        if (dto.getId() != null && userRepo.findById(dto.getId()).isPresent()) {
            throw new EntityAlreadyExistsException("userId: " + dto.getId() + " already exists");
        }
        UserEntity entity = mapper.toEntity(dto);
        return mapper.toDto(userRepo.save(entity));
    }

    @PutMapping("/")
    public UserDto update(@RequestBody UserDto dto) {

        if (dto.getId() == null) {
            throw new NotFoundEntityException("userId cant be empty");
        }
        UserEntity entity = mapper.toEntity(dto);
        return mapper.toDto(userRepo.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        if (id == null) {
            throw new NotFoundEntityException("userId cant be empty");
        }

        userRepo.deleteById(id);
    }

}
