package vzateychuk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vzateychuk.model.PostEntity;

public interface PostRepo extends JpaRepository<PostEntity, Long> {
}
