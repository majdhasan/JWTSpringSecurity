package life.majd.JWTSpringSecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@Entity //JPA
@Data //Lombok
@NoArgsConstructor //Lombok
@AllArgsConstructor//Lombok
public class User {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER) // Always load all the roles, once a user has been loaded
    private Collection<Role> roles = new ArrayList<>();
}
