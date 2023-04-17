package vzateychuk.mapper;

import org.springframework.stereotype.Component;

import vzateychuk.dto.UserDto;
import vzateychuk.map.Mapper;
import vzateychuk.model.UserEntity;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDto> {
    @Override
    public UserDto toDto(UserEntity entity) {

        return new UserDto(
                entity.getId(),
                entity.getUsername(),
                entity.getAmountOfPosts()
        );
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        return new UserEntity(dto.getId(), dto.getUsername(), dto.getAmountOfPosts());
    }
}
