package pe.fudi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path( "/posts")

public class PostResource {

        private static final List<Post> POSTS = List.of(
                new Post(626, "Fudi", "Hello World"),
                new Post(627, "Fudi", "Hello World"),
                new Post(628, "Fudi", "Hello World")
        );

        @GET
        @Produces({MediaType.APPLICATION_JSON})
        public List<Post> getPosts() {
            return POSTS;
        }
}

