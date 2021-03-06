package de.simpe.integration;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class GreetingRestTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/rest/hello")
          .then()
             .statusCode(200)
             .body(is("Hello World 22"));
    }

}