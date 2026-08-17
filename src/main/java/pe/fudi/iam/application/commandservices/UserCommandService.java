package pe.fudi.iam.application.commandservices;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.commands.SignUpCommand;

public interface UserCommandService {

    User signUp(SignUpCommand command);
}
