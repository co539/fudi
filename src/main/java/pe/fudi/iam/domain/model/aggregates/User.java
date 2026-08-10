package pe.fudi.iam.domain.model.aggregates;

import lombok.Getter;
import lombok.Setter;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;

@Getter
public class User {

    @Setter
    private Long id;

    @Setter
    private Username username;

    @Setter
    private Email email;

}
