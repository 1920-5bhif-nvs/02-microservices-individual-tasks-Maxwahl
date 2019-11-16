package at.htl.librarian;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {
    //Same tests as in exercise 1, as this is a wrapper for it and therefore it should do the same
    @Test
    public void testLoansSize() {
        given()
                .when().get("/librarian/loans")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }
    @Test
    public void testPersonsName() {
        given()
                .when().get("/librarian/persons/1")
                .then()
                .statusCode(200)
                .body("name", is("Meier"));
    }
    @Test void testLoanExemplars(){
        given()
                .when().get("/librarian/loans/1")
                .then()
                .statusCode(200)
                .body("exemplars.weariness",hasItems("undamaged", "used"));
    }
}