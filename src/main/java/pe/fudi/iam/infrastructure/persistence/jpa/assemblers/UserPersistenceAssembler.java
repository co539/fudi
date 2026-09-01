package pe.fudi.iam.infrastructure.persistence.jpa.assemblers;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.UserPersistenceEntity;

import java.util.stream.Collectors;

public final class UserPersistenceAssembler {

    private UserPersistenceAssembler() {
    }

    public static User toDomainFromPersistence(UserPersistenceEntity entity) {
        var domain = new User();

        domain.setId(entity.getId());
        domain.setUsername(entity.getUsername());
        domain.setEmail(entity.getEmail());
        domain.setPassword(entity.getPassword());

        entity.getRoles().stream()
                .map(RolePersistenceAssembler::toDomainFromPersistence)
                .forEach(domain::addRole);

        return domain;
    }

    public static UserPersistenceEntity toPersistenceFromDomain(User user) {
        var entity = new UserPersistenceEntity();

        if (user.getId() != null) {
            entity.setId(user.getId());
        }

        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRoles(
                user.getRoles().stream()
                        .map(RolePersistenceAssembler::toPersistenceFromDomain)
                        .collect(Collectors.toSet())
        );

        return entity;
    }
}