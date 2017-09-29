package com.example.demo;

import com.jayway.restassured.response.Response;
import org.junit.Test;

import static com.example.demo.harness.URI.PING_END_POINT;
import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class PersonalSpringBootApplicationTests extends BaseIntegration {

	@Test
    public void validateGetPing() {
        Response response = given().log().all().when().then().get(PING_END_POINT);
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.body().asString()).isEqualTo("Hello World");
    }

}
