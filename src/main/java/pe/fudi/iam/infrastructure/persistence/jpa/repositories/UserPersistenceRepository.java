package pe.fudi.iam.infrastructure.persistence.jpa.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;
import pe.fudi.iam.infrastructure.persistence.jpa.entities.UserPersistenceEntity;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserPersistenceRepository implements PanacheRepository<UserPersistenceEntity> {

    public Optional<UserPersistenceEntity> findByUsername(Username username) {
        return find("username", username).firstResultOptional();
    }

    public boolean existsByUsername(Username username){
        return count("username", username) > 0;
    }

    public Optional<UserPersistenceEntity> findByEmail(Email email) {
        return find("email", email).firstResultOptional();
    }

    public boolean existsByEmail(Email email){
        return count("email", email) > 0;
    }

    public List<UserPersistenceEntity> listAllWithRoles() {
        return find("select distinct u from UserPersistenceEntity u left join fetch u.roles").list();
    }
}
