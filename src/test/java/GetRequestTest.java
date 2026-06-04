import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GetRequestTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("GET")
    public void testGetRequestWithParameters() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode, "Ожидается статус ответа 200");
        System.out.println("Код ответа: " + statusCode);

        String foo1Value = response.jsonPath().getString("args.foo1");
        String foo2Value = response.jsonPath().getString("args.foo2");

        assertEquals("bar1", foo1Value);
        assertEquals("bar2", foo2Value);

        String responseUrl = response.jsonPath().getString("url");
        assertTrue(responseUrl.contains("foo1=bar1"));
        assertTrue(responseUrl.contains("foo2=bar2"));
    }
}