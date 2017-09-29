package com.example.demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonalSpringBootApplicationTests {

    private static final String PING_END_POINT = "/ping";

    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void setup() {
        RestAssured.port = serverPort;
    }

	@Test
    public void validateGetPing() {
        Response response = given().log().all().when().then().get(PING_END_POINT);
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.body().asString()).isEqualTo("Hello World");
    }

}
