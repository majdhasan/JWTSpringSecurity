package life.majd.JWTSpringSecurity;

import life.majd.JWTSpringSecurity.domain.Role;
import life.majd.JWTSpringSecurity.domain.User;
import life.majd.JWTSpringSecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MODERATOR"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Majd Hasan","majd","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Giulia Piemontese","giuls","1234",new ArrayList<>()));
			userService.saveUser(new User(null, "Leo Hasan","leo","1234",new ArrayList<>()));

			userService.addRoleToUser("majd","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("majd","ROLE_ADMIN");
			userService.addRoleToUser("giuls","ROLE_ADMIN");
			userService.addRoleToUser("leo","ROLE_USER");
			userService.addRoleToUser("leo","ROLE_MODERATOR");
		};
	}

}
