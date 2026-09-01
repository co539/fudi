package pe.fudi.iam.infrastructure.persistence.jpa.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;
import pe.fudi.iam.domain.repositories.UserRepository;
import pe.fudi.iam.infrastructure.persistence.jpa.assemblers.UserPersistenceAssembler;
import pe.fudi.iam.infrastructure.persistence.jpa.repositories.UserPersistenceRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final UserPersistenceRepository userPersistenceRepository;

    public UserRepositoryImpl(UserPersistenceRepository userPersistenceRepository) {
        this.userPersistenceRepository = userPersistenceRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userPersistenceRepository.findByIdOptional(id)
                .map(UserPersistenceAssembler::toDomainFromPersistence);
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        return userPersistenceRepository.findByUsername(username)
                .map(UserPersistenceAssembler::toDomainFromPersistence);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return userPersistenceRepository.findByEmail(email)
                .map(UserPersistenceAssembler::toDomainFromPersistence);
    }

    @Override
    public List<User> findAll() {
        return userPersistenceRepository.listAllWithRoles().stream()
                .map(UserPersistenceAssembler::toDomainFromPersistence)
                .toList();
    }

    @Override
    public boolean existsByUsername(Username username) {
        return userPersistenceRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return userPersistenceRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        var entity = UserPersistenceAssembler.toPersistenceFromDomain(user);
        userPersistenceRepository.persist(entity);
        return UserPersistenceAssembler.toDomainFromPersistence(entity);
    }
}