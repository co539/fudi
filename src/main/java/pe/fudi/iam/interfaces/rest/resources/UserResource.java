package pe.fudi.iam.interfaces.rest.resources;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "UserResponse",
        description = "User information response"
)
public record UserResource(

        @Schema(description = "User unique identifier", examples = "1")
        Long id,

        @Schema(description = "User username", examples = "john.doe")
        String username,

        @Schema(description = "User email", examples = "john@gmail.com")
        String email,

        @Schema(description = "Roles assigned to the user", examples = "[\"ROLE_USER\"]")
        List<String> roles
) {
}