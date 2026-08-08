package pe.fudi.iam.domain.repositories;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(Username username);

    Optional<User> findByEmail(Email email);

    List<User> findAll();

    boolean existsByUsername(Username username);

    boolean existsByEmail(Email email);
}