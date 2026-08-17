package pe.fudi.iam.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Schema(
        name = "SignUpRequest",
        description = "User sign-up request with credentials and roles"
)
public record SignUpResource(

        @NotBlank
        @Size(min = 3, max = 30)
        @Schema(
                description = "Desired username",
                examples = "john.doe",
                minLength = 3,
                maxLength = 30
        )
        String username,

        @NotBlank
        @Email
        @Size(max = 120)
        @Schema(
                description = "Desired email",
                examples = "john@gmail.com",
                maxLength = 120
        )
        String email,

        @NotBlank
        @Size(min = 8, max = 255)
        @Schema(
                description = "User password (minimum 8 characters)",
                examples = "SecurePass123!",
                minLength = 8,
                maxLength = 255
        )
        String password,

        @Schema(
                description = "Roles to assign to the user",
                examples = "[\"ROLE_USER\"]"
        )
        List<String> roles
) {
}