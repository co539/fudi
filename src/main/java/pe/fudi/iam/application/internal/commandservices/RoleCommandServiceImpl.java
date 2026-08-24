package pe.fudi.iam.application.internal.commandservices;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import pe.fudi.iam.application.commandservices.RoleCommandService;
import pe.fudi.iam.domain.model.commands.SeedRolesCommand;
import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.model.valueobjects.Roles;
import pe.fudi.iam.domain.repositories.RoleRepository;

import java.util.Arrays;

@ApplicationScoped
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void handle(SeedRolesCommand command) {
        for (Roles role : Roles.values()) {
            if (!roleRepository.existsByName(role)) {
                roleRepository.save(new Role(role));
            }
        }
    }
}
