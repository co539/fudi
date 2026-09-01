package pe.fudi.iam.infrastructure.persistence.jpa.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.domain.model.valueobjects.Roles;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.RolePersistenceEntity;

import java.util.Optional;

@ApplicationScoped
public class RolePersistenceRepository implements PanacheRepository<RolePersistenceEntity> {

    public Optional<RolePersistenceEntity> findByName(Roles name) {
        return find("name", name).firstResultOptional();
    }

    public boolean existsByName(Roles name) {
        return count("name", name) > 0;
    }
}
