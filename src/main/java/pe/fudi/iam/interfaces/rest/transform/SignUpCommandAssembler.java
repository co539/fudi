package pe.fudi.iam.interfaces.rest.transform;

import pe.fudi.iam.domain.model.commands.SignUpCommand;
import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;
import pe.fudi.iam.interfaces.rest.resources.SignUpResource;

import java.util.List;

public final class SignUpCommandAssembler {

    private SignUpCommandAssembler() {
    }

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() == null || resource.roles().isEmpty()
                ? List.of(Role.getDefaultRole())
                : resource.roles().stream()
                .map(Role::toRoleFromName)
                .toList();

        return new SignUpCommand(
                new Username(resource.username()),
                new Email(resource.email()),
                resource.password(),
                roles
        );
    }
}