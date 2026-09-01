package pe.fudi.iam.domain.model.aggregates;

import lombok.Getter;
import lombok.Setter;
import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class User {

    @Setter
    private Long id;

    @Setter
    private Username username;

    @Setter
    private Email email;

    @Setter
    private String password;

    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Username username, Email email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Username username, Email email, String password, List<Role> roles) {
        this(username, email, password);
        addRoles(roles);
    }

    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    public User addRoles(List<Role> roles) {
        var validatedRoleSet = Role.validateRoleSet(roles);
        this.roles.addAll(validatedRoleSet);
        return this;
    }
}