package pe.fudi.iam.infrastructure.persistence.jpa.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.model.valueobjects.Roles;
import pe.fudi.iam.domain.repositories.RoleRepository;
import pe.fudi.iam.infrastructure.persistence.jpa.assemblers.RolePersistenceAssembler;
import pe.fudi.iam.infrastructure.persistence.jpa.repositories.RolePersistenceRepository;

import java.util.Optional;

@ApplicationScoped
public class RoleRepositoryImpl implements RoleRepository {

    private final RolePersistenceRepository rolePersistenceRepository;

    public RoleRepositoryImpl(RolePersistenceRepository rolePersistenceRepository) {
        this.rolePersistenceRepository = rolePersistenceRepository;
    }

    @Override
    public Optional<Role> findByName(Roles name) {
        return rolePersistenceRepository.findByName(name)
                .map(RolePersistenceAssembler::toDomainFromPersistence);
    }

    @Override
    public boolean existsByName(Roles name) {
        return rolePersistenceRepository.existsByName(name);
    }

    public Role save(Role role) {
        var entity = RolePersistenceAssembler.toPersistenceFromDomain(role);
        rolePersistenceRepository.persist(entity);
        return RolePersistenceAssembler.toDomainFromPersistence(entity);
    }
}
