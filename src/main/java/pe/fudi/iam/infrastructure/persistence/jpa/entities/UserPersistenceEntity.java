package pe.fudi.iam.infrastructure.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;
import pe.fudi.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserPersistenceEntity extends AuditableAbstractPersistenceEntity {

    @Column(name = "username", nullable = false, unique = true, length = 30)
    private Username username;

    @Column(name = "email", nullable = false, unique = true, length = 120)
    private Email email;
}