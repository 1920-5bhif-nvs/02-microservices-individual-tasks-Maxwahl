import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoansResourceIT {

    private static Client client;
    private static WebTarget tut;

    @BeforeAll
    public static void init(){
        client = ClientBuilder.newClient();
        tut = client.target("http://localhost:8080/loans/");
    }

    @Test
    public void fetchLoan(){
        Response response =tut.request().get() ;
        assertEquals(response.getStatus(),200);
        JsonArray jsonArray  = response.readEntity(JsonArray.class);
        System.out.println("resulting array is:" +  jsonArray);
    }
}
