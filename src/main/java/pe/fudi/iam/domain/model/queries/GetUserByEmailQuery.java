package pe.fudi.iam.domain.model.queries;

import pe.fudi.iam.domain.model.valueobjects.Email;

public record GetUserByEmailQuery(Email email) {
}
