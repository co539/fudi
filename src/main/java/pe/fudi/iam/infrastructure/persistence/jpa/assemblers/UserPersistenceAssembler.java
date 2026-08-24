package pe.fudi.iam.infrastructure.persistence.jpa.assemblers;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.UserPersistenceEntity;

import java.util.stream.Collectors;

public final class UserPersistenceAssembler {

    private UserPersistenceAssembler() {
        /* This utility class should not be instantiated */
    }

    public static User toDomainFromPersistence(UserPersistenceEntity entity) {
        if (entity == null) {
            return null;
        }

        var domain = new User();
        domain.setId(entity.getId());
        domain.setUsername(entity.getUsername());
        domain.setEmail(entity.getEmail());
        domain.setPassword(entity.getPassword());
        domain.setRoles(
                entity.getRoles().stream()
                        .map(RolePersistenceAssembler::toDomainFromPersistence)
                        .collect(Collectors.toSet())
        );

        return domain;
    }

    public static UserPersistenceEntity toPersistenceFromDomain(User user) {
        if (user == null) {
            return null;
        }

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
