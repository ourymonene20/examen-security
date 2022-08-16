package sn.isi.securityms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.isi.securityms.dto.AppRolesDto;
import sn.isi.securityms.dto.AppUserDto;
import sn.isi.securityms.entities.AppRoles;
import sn.isi.securityms.entities.AppUser;
import sn.isi.securityms.services.AccountService;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityMsApplication {



	public static void main(String[] args) {
		SpringApplication.run(SecurityMsApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(AccountService userService) {
		return args -> {

			/*// Enregistrer des utilisateurs
            userService.saveUser(new AppUserDto(null, "John Doe", "jDoe","1234", null));
            userService.saveUser(new AppUserDto(null, "Ahmed Bâ", "Ahmed","Passer123", null));
            userService.saveUser(new AppUserDto(null, "Fatim Sy", "Fati","1234", null));
            userService.saveUser(new AppUserDto(null, "Coumba Tall", "CTall","Coumba4", null));
*/
            // Permet d'afficher les utilisateurs créés via leur id ainsi que leur name
           /* userService.findUsers().forEach(user -> {
                System.out.println(user.getId() + " " + user.getName());
            });*/

           /* // Enregistrer un rôle
            userService.saveRoles(new AppRolesDto(null, "Administrateur"));
            userService.saveRoles(new AppRolesDto(null, "Utilisateur"));
*/
            // Ajout d'un rôle à un utilisateur
            /*userService.addRoleToUser("Ahmed","Administrateur");
            userService.addRoleToUser("Fati","Utilisateur");
*/


           /*userService.saveRoles(new AppRoles(null, "Role_User"));
           userService.saveRoles(new AppRoles(null, "Role_Manager"));
           userService.saveRoles(new AppRoles(null, "Role_Admin"));
           userService.saveRoles(new AppRoles(null, "Role_Super_Admin"));

            userService.saveUser(new AppUser(null, "John Doe", "jDoe","1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Ahmed Bâ", "Ahmed","Passer123", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Fatim Sy", "Fati","1234", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Coumba Tall", "CTall","Coumba4", new ArrayList<>()));

           userService.addRoleToUser("jDoe", "Role_User");
           userService.addRoleToUser("Ahmed", "Role_Manager");
           userService.addRoleToUser("Fati", "Role_Admin");
           userService.addRoleToUser("CTall", "Role_Super_Admin");*/

		};
	}
}
