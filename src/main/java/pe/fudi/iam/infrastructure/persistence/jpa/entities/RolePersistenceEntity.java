package pe.fudi.iam.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.fudi.iam.domain.model.valueobjects.Roles;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RolePersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true, length = 20)
    private Roles name;
}
