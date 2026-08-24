package pe.fudi.iam.domain.model.commands;

import pe.fudi.iam.domain.model.entities.Role;
import pe.fudi.iam.domain.model.valueobjects.Email;
import pe.fudi.iam.domain.model.valueobjects.Username;

import java.util.List;

public record SignUpCommand(Username username, Email email, String password, List<Role> roles) {
}
