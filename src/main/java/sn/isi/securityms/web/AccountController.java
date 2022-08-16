package sn.isi.securityms.web;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sn.isi.securityms.dto.AppRolesDto;
import sn.isi.securityms.dto.AppUserDto;
import sn.isi.securityms.entities.AppUser;
import sn.isi.securityms.services.AccountService;

import java.net.URI;
import java.util.List;

@RestController

public class AccountController {

    private AccountService userService;

    public AccountController(AccountService userService) {
        this.userService = userService;
    }

    @PostAuthorize("hasAuthority('Administrateur')")
    @GetMapping("/users")
    public List<AppUserDto> getUsers() {
        return userService.findUsers();
    }

    @PostAuthorize("hasAuthority('Administrateur')")
    @PostMapping("/addRoleToUser/{username}/{roleName}")
    public Object addRoleToUser(@PathVariable String username, @PathVariable String roleName) {
        userService.addRoleToUser(username, roleName);
        return "Utilisateur mis à jour avec succès !";
    }

    @PostAuthorize("hasAuthority('Administrateur')")
    @PostMapping("/users/save")
    public ResponseEntity<AppUserDto> saveUser(@RequestBody AppUserDto user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostAuthorize("hasAuthority('Administrateur')")
    @PostMapping("/role/save")
    public ResponseEntity<AppRolesDto> saveRole(@RequestBody AppRolesDto role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRoles(role));
    }



}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}
