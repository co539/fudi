package pe.fudi.iam.infrastructure.persistence.jpa.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.UserPersistenceEntity;

import java.util.Optional;

@ApplicationScoped
public class UserPersistenceRepository implements PanacheRepository<UserPersistenceEntity> {

    public Optional<UserPersistenceEntity> findByUsername(String username) {
        return find("username", username).firstResultOptional();
    }

    public boolean existsByUsername(String username){
        return count("username", username) > 0;
    }

    public Optional<UserPersistenceEntity> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public boolean existsByEmail(String email){
        return count("email", email) > 0;
    }
}
