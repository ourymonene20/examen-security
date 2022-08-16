package sn.isi.securityms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sn.isi.securityms.dto.AppRolesDto;
import sn.isi.securityms.entities.AppRoles;
import sn.isi.securityms.repositories.AppRoleRepository;
import sn.isi.securityms.services.AccountService;
import sn.isi.securityms.services.AccountServiceImpl;

@SpringBootTest
class SecurityMsApplicationTests {

	/*@Autowired
	private AppRoleRepository roleRepository;
	@Autowired
	private AccountServiceImpl useSercice;

	public SecurityMsApplicationTests(AppRoleRepository roleRepository, AccountServiceImpl useSercice) {
		this.roleRepository = roleRepository;
		this.useSercice = useSercice;
	}

	@Test
	void contextLoads() {
	}


*/
	/*@Test
	void addRoles(){
		//AppRoles dto  = new AppRolesDto(AppRoles.class);
		AppRoles dto = new AppRoles();
		dto.setName("MARKITING");
		roleRepository.save(dto);
		//roleRepository.save(new AppRolesDto(null, "Administrateur"));
		//useSercice.saveRoles(new AppRolesDto(null, "Utilisateur"));
	}*/
}
