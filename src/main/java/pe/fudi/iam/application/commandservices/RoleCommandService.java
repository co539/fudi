package pe.fudi.iam.application.commandservices;

import pe.fudi.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {

    void handle(SeedRolesCommand command);
}
