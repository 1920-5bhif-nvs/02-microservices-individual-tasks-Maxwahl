package at.htl.librarian;


import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("librarian")
public class Librarian {
    @Inject
    @RestClient
    LoanWrapperResource loanWrapperResource;

    @GET
    @Path("/loans")
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "performedChecks", description = "How many rest requests have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the rest request", unit = MetricUnits.MILLISECONDS)
    @Retry(maxRetries = 2)
    @Fallback(fallbackMethod = "noLoans")
    public Response loans() {
        return Response.ok().entity(loanWrapperResource.getLoans()).build();
    }

    public Response noLoans(){
        return Response.ok().entity(Json.createArrayBuilder().build()).build();
    }
}
