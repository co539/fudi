package pe.fudi.iam.domain.model.queries;

import pe.fudi.iam.domain.model.valueobjects.Username;

public record GetUserByUsernameQuery(Username username) {
}
