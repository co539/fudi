package pe.fudi.iam.application.internal.queryservices;

import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.application.queryservices.UserQueryService;
import pe.fudi.iam.domain.model.aggregates.User;
import pe.fudi.iam.domain.model.queries.GetAllUsersQuery;
import pe.fudi.iam.domain.model.queries.GetUserByEmailQuery;
import pe.fudi.iam.domain.model.queries.GetUserByIdQuery;
import pe.fudi.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.fudi.iam.domain.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById (GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> getUserByUsername (GetUserByUsernameQuery query) {
        return userRepository.findByUsername(query.username());
    }

    @Override
    public Optional<User> getUserByEmail (GetUserByEmailQuery query) {
        return userRepository.findByEmail(query.email());
    }
}
