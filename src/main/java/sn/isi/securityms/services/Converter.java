package sn.isi.securityms.services;

import org.springframework.stereotype.Service;
import sn.isi.securityms.dto.AppRolesDto;
import sn.isi.securityms.dto.AppUserDto;
import sn.isi.securityms.entities.AppRoles;
import sn.isi.securityms.entities.AppUser;
import sn.isi.securityms.repositories.AppRoleRepository;
import sn.isi.securityms.repositories.AppUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class Converter {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    public Converter(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    public AppUser AppUserDtoToAppUserEntity(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        appUser.setId(appUserDto.getId());
        appUser.setName(appUserDto.getName());
        appUser.setUsername(appUserDto.getUsername());
        appUser.setPassword(appUserDto.getPassword());

        if (appUserDto.getRoles() != null) {
            List<AppRoles> appRoles = new ArrayList<AppRoles>();
            appUserDto.getRoles().forEach(nom -> {
                AppRoles appRole = appRoleRepository.findByName(nom);
                appRoles.add(appRole);
            });
            appUser.setRoles(appRoles);
        }

        return appUser;
    }

    public AppUserDto AppUserEntityToAppUserDto(AppUser appUser) {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setId(appUser.getId());
        appUserDto.setName(appUser.getName());
        appUserDto.setUsername(appUser.getUsername());
        appUserDto.setPassword(appUser.getPassword());


        if (appUser.getRoles() != null) {
            List<String> nomRoles = new ArrayList<String>();
            appUser.getRoles().forEach(roles -> {
                nomRoles.add(roles.getName());
            });
            appUserDto.setRoles(nomRoles);
        }

        return appUserDto;
    }

    public AppRoles appRoleDtoToAppRoleEntity(AppRolesDto appRoleDto) {
        AppRoles appRole = new AppRoles();
        appRole.setId(appRoleDto.getId());
        appRole.setName(appRoleDto.getName());
        return appRole;

    }

    public AppRolesDto appRoleEntityToAppRoleDto (AppRoles appRole) {
        AppRolesDto appRolesDto = new AppRolesDto();
        appRolesDto.setId(appRole.getId());
        appRolesDto.setName(appRole.getName());

        return appRolesDto;
    }
}
