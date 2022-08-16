package sn.isi.securityms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {

    private Long id;
    private String name;
    private String username;
    private String password;

    private Collection<String> roles = new ArrayList<>();
}
