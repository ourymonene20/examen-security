package sn.isi.securityms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.securityms.entities.AppRoles;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRoles, Long> {
    AppRoles findByName(String name);
}
