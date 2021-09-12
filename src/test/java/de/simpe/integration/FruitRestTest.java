package de.simpe.integration;

import de.simpe.fruit.Fruit;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FruitRestTest {

    @Test
    @Order(1)
    public void testGetFruitsDefault(){
        Set<Fruit> fruits = given()
                .when().get("/rest/fruits")
                .as(new TypeRef<Set<Fruit>>() {
                });
        assertThat(fruits.contains(new Fruit("Apple", "Winter fruit"))).isTrue();
        assertThat(fruits.contains(new Fruit("Pineapple", "Tropical fruit"))).isTrue();
        assertThat(fruits.contains(new Fruit("Test", "Test"))).isFalse();
    }

    @Test
    @Order(2)
    public void testGetFruitsPost() {
        Fruit postFruit1 = new Fruit("Melon", "Round Fruit");
        Response response = given().contentType("application/json;charset=UTF-8")
                .body(postFruit1)
                .post("/rest/fruits")
                .then()
                .statusCode(200)
                .extract()
                .response();
        Set<Fruit> fruits = response.getBody().as(new TypeRef<Set<Fruit>>() {
        });
        assertThat(fruits.contains(postFruit1)).isTrue();
    }

    @Test
    @Order(3)
    public void testGetFruitsDelete() {
        Fruit postFruit1 = new Fruit("Melon", "Round Fruit");
        Response response = given().contentType("application/json;charset=UTF-8")
                .body(postFruit1)
                .delete("/rest/fruits")
                .then()
                .statusCode(200)
                .extract()
                .response();
        Set<Fruit> fruits = response.getBody().as(new TypeRef<Set<Fruit>>() {
        });
        assertThat(fruits.contains(postFruit1)).isFalse();
    }
}