package epita.controller;

import epita.datamodel.Role;
import epita.exceptions.BadRequestAlertException;
import epita.exceptions.ResourceNotFoundException;
import epita.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/roles")
    public ResponseEntity<Role> createRole(@RequestBody Role role) throws URISyntaxException {
        if (role.getId() != null) {
            throw new BadRequestAlertException("ID Exisits");
        }
        Role result = roleRepository.createRole(role);
        return ResponseEntity.created(new URI("/api/roles/" + result.getId()))
                .body(result);
    }


    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleRepository.getRoles();
    }


}
