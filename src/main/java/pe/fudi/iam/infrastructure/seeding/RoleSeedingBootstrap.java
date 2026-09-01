package pe.fudi.iam.infrastructure.seeding;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import pe.fudi.iam.application.commandservices.RoleCommandService;
import pe.fudi.iam.domain.model.commands.SeedRolesCommand;

public class RoleSeedingBootstrap {

    private final RoleCommandService roleCommandService;

    public RoleSeedingBootstrap(RoleCommandService roleCommandService) {
        this.roleCommandService = roleCommandService;
    }

    public void seed(@Observes StartupEvent event) {
        roleCommandService.handle(new SeedRolesCommand());
    }
}
