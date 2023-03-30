package org.drools.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class DMNTest {

    @Test
    public void test1() {
        given()
          .body("{ \"inputNumber\": 8 }")
          .contentType(ContentType.JSON)
          .when()
            .post("/number_classifier")
          .then()
            .statusCode(200)
            .body("classifications", is(List.of("Small", "Positive", "Even") ));
    }
}
