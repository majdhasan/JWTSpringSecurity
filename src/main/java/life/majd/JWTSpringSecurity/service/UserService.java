package life.majd.JWTSpringSecurity.service;

import life.majd.JWTSpringSecurity.domain.Role;
import life.majd.JWTSpringSecurity.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    // Assuming there are no duplicate usernames
    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    // Poor: could cause very high performance latency issues in case there are a lot of users in the database
    // should provide possibility to limit the requested amount of users (i.e page 1,2,3..)
    List<User> getUsers();

}
