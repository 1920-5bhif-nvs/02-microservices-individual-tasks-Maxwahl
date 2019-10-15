package at.htl.librarian;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface PersonWrapperResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons")
    JsonArray getPersons();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons/{id}")
    JsonObject getPerson(@PathParam("id") long id);
}
