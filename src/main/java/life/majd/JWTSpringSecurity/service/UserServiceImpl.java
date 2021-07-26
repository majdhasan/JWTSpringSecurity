package life.majd.JWTSpringSecurity.service;

import life.majd.JWTSpringSecurity.domain.Role;
import life.majd.JWTSpringSecurity.domain.User;
import life.majd.JWTSpringSecurity.repo.RoleRepo;
import life.majd.JWTSpringSecurity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor // comes from Lombok and injects the required dependencies
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving a new user to the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving a new role with the name {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        // saves the changes automatically, because we are using the transactional annotation
        user.getRoles().add(role);
        log.info("Add the role {} to the user {}", role.getName(), user.getUsername());
    }

    @Override
    public User getUser(String username) {
        log.info("fetching the user with the username {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetching all users");
        return userRepo.findAll();
    }
}
