import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("PATCH text/plain")
public class PatchRequestTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("PATCH text/plain test")
    public void patchTextPlainTest() {
        String textToSend = "PATCH text/plain text";

        System.out.println("Текст для отправки: " + textToSend);

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(textToSend)
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode, "Ожидается статус ответа 200");
        System.out.println("Код ответа: " + statusCode);

        String actualData = response.jsonPath().getString("data");

        assertThat(actualData).isEqualTo(textToSend);
        System.out.println("Поле data содержит: " + actualData);

        String url = response.jsonPath().getString("url");
        assertThat(url).isEqualTo("https://postman-echo.com/patch");

        String contentType = response.jsonPath().getString("headers.content-type");
        assertThat(contentType).contains("text/plain");
        System.out.println("Хэдер Content-Type: " + contentType);
    }
}