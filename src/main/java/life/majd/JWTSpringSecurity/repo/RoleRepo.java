package life.majd.JWTSpringSecurity.repo;

import life.majd.JWTSpringSecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
