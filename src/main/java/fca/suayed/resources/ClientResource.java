package fca.suayed.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import fca.suayed.dal.StoreDal;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/clietn")
public class ClientResource {

    @Inject
    StoreDal storeDal;

    @GET
    @Path("/all")
    @jakarta.ws.rs.Produces(MediaType.APPLICATION_JSON)
    @Operation(summary="Get all clients")
    @APIResponses(value = {
            @APIResponse(responseCode="200",content=@Content(mediaType=MediaType.APPLICATION_JSON))
    })
    public Response getClient() {
        var responseDto = storeDal.getClient();
        return Response.ok(responseDto).build();
    }
}
