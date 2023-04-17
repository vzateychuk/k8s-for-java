package vzateychuk.service;

import vzateychuk.model.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostEntity> findAll();

    Optional<PostEntity> findById(Long id);

    PostEntity save(PostEntity entity);

    void deleteById(Long id);
}
