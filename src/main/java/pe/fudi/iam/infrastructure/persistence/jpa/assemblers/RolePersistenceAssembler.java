package pe.fudi.iam.infrastructure.persistence.jpa.assemblers;

import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.RolePersistenceEntity;

public final class RolePersistenceAssembler {

    private RolePersistenceAssembler() {
        /* This utility class should not be instantiated */
    }

    public static Role toDomainFromPersistence(RolePersistenceEntity entity) {
        if (entity == null) return null;
        return new Role(entity.getId(), entity.getName());
    }

    public static RolePersistenceEntity toPersistenceFromDomain(Role role) {
        if (role == null) return null;
        var entity = new RolePersistenceEntity();
        if (role.getId() != null) entity.setId(role.getId());
        entity.setName(role.getName());
        return entity;
    }
}
