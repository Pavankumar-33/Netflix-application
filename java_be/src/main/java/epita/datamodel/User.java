package epita.datamodel;

import org.apache.commons.lang3.StringUtils;


import javax.persistence.*;
import java.util.Locale;


@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 60)
    private String password;


    @Column(name = "first_name", length = 50)
    private String firstname;


    @Column(name = "last_name", length = 50)
    private String lastname;

    @Column(length = 254, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    // Lowercase the login before saving it in database
    public void setUsername(String login) {
        this.username = StringUtils.lowerCase(login, Locale.ENGLISH);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
