package pe.fudi.iam.application.queryservices;

import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.queries.GetAllUsersQuery;
import pe.fudi.iam.domain.model.queries.GetUserByEmailQuery;
import pe.fudi.iam.domain.model.queries.GetUserByIdQuery;
import pe.fudi.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {

    List<User> getAllUsers(GetAllUsersQuery query);

    Optional<User> getUserById(GetUserByIdQuery query);

    Optional<User> getUserByUsername(GetUserByUsernameQuery query);

    Optional<User> getUserByEmail(GetUserByEmailQuery query);
}
