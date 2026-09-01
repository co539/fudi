package pe.fudi.iam.infrastructure.persistence.jpa.assemblers;

import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.RolePersistenceEntity;

public final class RolePersistenceAssembler {

    private RolePersistenceAssembler() {
    }

    public static Role toDomainFromPersistence(RolePersistenceEntity entity) {
        return new Role(entity.getId(), entity.getName());
    }

    public static RolePersistenceEntity toPersistenceFromDomain(Role role) {
        var entity = new RolePersistenceEntity();

        if (role.getId() != null) {
            entity.setId(role.getId());
        }

        entity.setName(role.getName());

        return entity;
    }
}