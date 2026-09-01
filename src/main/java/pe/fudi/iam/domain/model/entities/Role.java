package pe.fudi.iam.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.fudi.iam.domain.model.valueobjects.Roles;

import java.util.List;

@Getter
@AllArgsConstructor
public class Role {

    private Long id;

    private Roles name;

    public Role(Roles name) {
        this.name = name;
    }

    public String getStringName() {
        return name.name();
    }

    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_USER);
    }

    public static Role toRoleFromName(String name) {
        return new Role(Roles.valueOf(name));
    }

    public static List<Role>validateRoleSet(List<Role> roles) {
        if (roles==null || roles.isEmpty()) return List.of(getDefaultRole());
        return roles;
    }
}
