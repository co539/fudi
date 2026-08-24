package pe.fudi.iam.application.internal.commandservices;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import pe.fudi.iam.application.commandservices.UserCommandService;
import pe.fudi.iam.application.internal.outboundservices.hashing.HashingService;
import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.commands.SignUpCommand;
import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.repositories.RoleRepository;
import pe.fudi.iam.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HashingService hashingService;

    public UserCommandServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            HashingService hashingService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hashingService = hashingService;
    }

    @Override
    @Transactional
    public User signUp(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("Email already exists");
        }

        List<Role> resolvedRoles = new ArrayList<>();
        for (Role role : command.roles()) {
            var found = roleRepository.findByName(role.getName());
            if (found.isEmpty()) {
                throw new IllegalArgumentException("Role not found: " + role.getName());
            }
            resolvedRoles.add(found.get());
        }

        var hashedPassword = hashingService.hash(command.password());
        var user = new User(command.username(), command.email(), hashedPassword);
        user.addRoles(resolvedRoles);

        return userRepository.save(user);
    }
}