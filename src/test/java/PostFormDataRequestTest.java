import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("POST form-data")
public class PostFormDataRequestTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("POST form-data test")
    public void postFormDataTest() {
        Map<String, String> formData = new HashMap<>();
        formData.put("firstName", "Ivan");
        formData.put("lastName", "Ivanov");
        formData.put("email", "ivan@ivanmail.com");
        formData.put("age", "41");
        formData.put("city", "Ivanovo");

        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParams(formData)
                .when()
                .post("/post")
                .then()
                .log().body()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode, "Ожидается статус ответа 200");
        System.out.println("Код ответа: " + statusCode);

        Map<String, String> actualFormData = response.jsonPath().getMap("form");

        assertThat(actualFormData)
                .isNotNull()
                .containsEntry("firstName", "Ivan")
                .containsEntry("lastName", "Ivanov")
                .containsEntry("email", "ivan@ivanmail.com")
                .containsEntry("age", "41")
                .containsEntry("city", "Ivanovo");

        String url = response.jsonPath().getString("url");
        assertThat(url).isEqualTo("https://postman-echo.com/post");

        String contentType = response.jsonPath().getString("headers.content-type");
        assertThat(contentType).contains("application/x-www-form-urlencoded");

        String data = response.jsonPath().getString("data");
        assertThat(data).isNullOrEmpty();
    }
}