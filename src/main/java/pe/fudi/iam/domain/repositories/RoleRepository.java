package pe.fudi.iam.domain.repositories;

import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.model.valueobjects.Roles;

import java.util.Optional;

public interface RoleRepository {

    Optional<Role> findByName(Roles name);

    boolean existsByName(Roles name);

    Role save(Role role);
}
