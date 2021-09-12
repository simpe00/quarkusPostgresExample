package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.acme.gift.Gift;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GreetingRestTest1 {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/default/hello")
          .then()
             .statusCode(200)
             .body(is("Hello World 22"));
    }

//    @Test
//    @Order(1)
//    public void testGetGiftEmpty(){
//        List<Gift> gifts = given()
//                .when().get("/rest/getGift")
//                .as(new TypeRef<List<Gift>>() {
//                });
//        assertThat(gifts).isEmpty();
//    }
//
//    @Test
//    @Order(2)
//    public void testSaveGift(){
//        Gift gift = new Gift(1L, "testSaveGift");
//        Response response = given().contentType("application/json;charset=UTF-8")
//                .body(gift)
//                .post("/rest/saveGift")
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
//        Gift giftBody = response.getBody().as(new TypeRef<Gift>() {});
//        assertThat(gift).isEqualTo(giftBody);
//    }
//
//    @Test
//    @Order(3)
//    public void testGetGiftWithElement(){
//        Gift gift = new Gift(1L, "testSaveGift");
//        List<Gift> gifts = given()
//                .when().get("/rest/getGift")
//                .as(new TypeRef<List<Gift>>() {
//                });
//        assertThat(gifts.contains(gift)).isTrue();
//    }

}