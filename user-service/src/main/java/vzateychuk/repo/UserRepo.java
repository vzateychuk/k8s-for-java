package vzateychuk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vzateychuk.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
