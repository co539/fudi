package pe.fudi.iam.interfaces.rest;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.ResponseStatus;
import pe.fudi.iam.application.commandservices.UserCommandService;
import pe.fudi.iam.application.queryservices.UserQueryService;
import pe.fudi.iam.domain.model.queries.GetUserByIdQuery;
import pe.fudi.iam.interfaces.rest.resources.SignUpResource;
import pe.fudi.iam.interfaces.rest.resources.UserResource;
import pe.fudi.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import pe.fudi.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;

@Path("/api/v1/users")
@Tag(name = "Users", description = "Users management endpoints")
public class UsersController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UsersController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Get all users",
            description = "Retrieves every user registered in the system."
    )
    @APIResponse(
            responseCode = "200",
            description = "Users retrieved successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = UserResource.class)
            )
    )
    public List<UserResource> getAllUsers() {
        return userQueryService.getAllUsers().stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Get user by id",
            description = "Retrieves a single user by its unique identifier."
    )
    @APIResponse(
            responseCode = "200",
            description = "User retrieved successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = UserResource.class)
            )
    )
    @APIResponse(responseCode = "404", description = "User not found")
    public UserResource getUserById(
            @PathParam("userId")
            @Parameter(description = "Unique user identifier", example = "1", required = true)
            Long userId
    ) {
        var user = userQueryService.getUserById(new GetUserByIdQuery(userId))
                .orElseThrow(NotFoundException::new);
        return UserResourceFromEntityAssembler.toResourceFromEntity(user);
    }

    @POST
    @Path("/sign-up")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(201)
    @Operation(
            summary = "Sign up",
            description = "Creates a new user account with the given credentials and roles."
    )
    @APIResponse(
            responseCode = "201",
            description = "User created successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(implementation = UserResource.class)
            )
    )
    @APIResponse(responseCode = "400", description = "Invalid sign-up request")
    public UserResource signUp(@Valid SignUpResource resource) {
        var command = SignUpCommandFromResourceAssembler.toCommandFromResource(resource);
        var user = userCommandService.signUp(command);
        return UserResourceFromEntityAssembler.toResourceFromEntity(user);
    }
}