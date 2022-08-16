package epita.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import epita.datamodel.User;
import epita.datamodel.UserLogin;
import epita.exceptions.BadRequestAlertException;
import epita.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = new ArrayList<>();
            userRepository.getUsers().forEach(users::add);
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {

        if (user.getId() != null) {
            throw new BadRequestAlertException("ID Exisits");
            // Lowercase the user login before comparing with database
        } else {
            User newUser = userRepository.createUser(user);
            return ResponseEntity.created(new URI("/api/users/" + newUser.getId()))
                    .body(newUser);
        }
    }

    @PostMapping("/checkuser")
    public ResponseEntity<User> createUser(@RequestBody UserLogin userLogin) throws URISyntaxException {

        User newUser = userRepository.getByUsername(userLogin.getUsername(), userLogin.getPassword());
        if (newUser != null)
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
