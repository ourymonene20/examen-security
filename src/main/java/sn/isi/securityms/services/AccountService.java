package sn.isi.securityms.services;


import sn.isi.securityms.dto.AppRolesDto;
import sn.isi.securityms.dto.AppUserDto;

import java.util.List;

public interface AccountService {

    public AppUserDto saveUser(AppUserDto appUserdto);
    public AppRolesDto saveRoles(AppRolesDto appRolesdto);
    public AppUserDto loadAppUserByUsername(String username);
    public List<AppUserDto> findUsers();
    void addRoleToUser(String username, String roleName);

}
