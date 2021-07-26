package life.majd.JWTSpringSecurity.controller;

import life.majd.JWTSpringSecurity.domain.Role;
import life.majd.JWTSpringSecurity.domain.User;
import life.majd.JWTSpringSecurity.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(Role role) {
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

    @PostMapping("/user/addRole")
    public ResponseEntity<?> addRoleToUser(UserRoleForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    private class UserRoleForm {
        private String username;
        private String roleName;
    }
}
