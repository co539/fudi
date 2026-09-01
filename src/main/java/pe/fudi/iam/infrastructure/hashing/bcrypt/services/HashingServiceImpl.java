package pe.fudi.iam.infrastructure.hashing.bcrypt.services;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import pe.fudi.iam.application.internal.outboundservices.hashing.HashingService;

@ApplicationScoped
public class HashingServiceImpl implements HashingService {

    @Override
    public String hash(String password) {
        return BcryptUtil.bcryptHash(password);
    }

    @Override
    public boolean matches(String password, String hash) {
        return BcryptUtil.matches(password, hash);
    }
}
