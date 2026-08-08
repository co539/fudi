package pe.fudi.iam.infrastructure.persistence.jpa.assemblers;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.UserPersistenceEntity;

public final class UserPersistenceAssembler {

    private UserPersistenceAssembler() {
        /* This utility class should not be instantiated */
    }

    public static User toDomainFromPersistence(UserPersistenceEntity entity) {

        if (entity == null) return null;

        var domain = new User();
        domain.setId(entity.getId());
        domain.setUsername(new Username(entity.getUsername()));
        domain.setEmail(new Email(entity.getEmail()));
        return domain;
    }

    public static UserPersistenceEntity toPersistenceFromDomain(User user) {
        if (user == null) return null;

        var entity = new UserPersistenceEntity();
        if (user.getId() != null) entity.setId(user.getId());
        entity.setUsername(user.getUsername().value());
        entity.setEmail(user.getEmail().value());
        return entity;
    }
}
