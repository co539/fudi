package pe.fudi.iam.interfaces.rest.resources;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(
        name = "UserResponse",
        description = "User information response"
)
public record UserResource(
        @Schema(description = "User unique identifier", examples = "1")
        Long id,

        @Schema(description = "User username", examples = "john.doe")
        String username
) {

}