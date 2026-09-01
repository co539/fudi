package pe.fudi.iam.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;
import pe.fudi.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserPersistenceEntity extends AuditableAbstractPersistenceEntity {

    @Column(name = "username", nullable = false, unique = true, length = 30)
    private Username username;

    @Column(name = "email", nullable = false, unique = true, length = 120)
    private Email email;

    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolePersistenceEntity> roles = new HashSet<>();
}