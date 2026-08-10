package pe.fudi.iam.interfaces.rest.transform;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.interfaces.rest.resources.UserResource;

public final class UserResourceFromEntityAssembler {

    private UserResourceFromEntityAssembler() {
        /* This utility class should not be instantiated */
    }

    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(user.getId(), user.getUsername().value());
    }

}
