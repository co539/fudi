package pe.fudi.iam.application.internal.outboundservices.hashing;

public interface HashingService {

    String hash(String password);

    boolean matches(String password, String hash);

}
