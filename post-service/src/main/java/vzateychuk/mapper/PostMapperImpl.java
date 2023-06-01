package vzateychuk.mapper;

import org.springframework.stereotype.Component;

import vzateychuk.dto.PostDto;
import vzateychuk.map.Mapper;
import vzateychuk.model.PostEntity;

@Component
public class PostMapperImpl implements Mapper<PostEntity, PostDto> {
    @Override
    public PostDto toDto(PostEntity entity) {

        return new PostDto(
                entity.getId(),
                entity.getAuthorId(),
                entity.getText(),
                entity.getPostedAt(),
                entity.getTopic()
        );
    }

    @Override
    public PostEntity toEntity(PostDto dto) {

        return new PostEntity(
                dto.getId(),
                dto.getAuthorId(),
                dto.getText(),
                dto.getPostedAt(),
                dto.getTopic()
        );
    }
}
