package life.majd.JWTSpringSecurity.repo;

import life.majd.JWTSpringSecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
