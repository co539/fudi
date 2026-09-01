package pe.fudi.iam.interfaces.rest.transform;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.interfaces.rest.resources.UserResource;

public final class UserResourceAssembler {

    private UserResourceAssembler() {
    }

    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getId(),
                user.getUsername().value(),
                user.getEmail().value(),
                user.getRoles().stream().map(Role::getStringName).toList());
    }
}