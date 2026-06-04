import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("POST raw text")
public class PostRawTextRequestTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com/";
    }

    @Test
    @DisplayName("POST raw text")
    public void postRawTextTest() {
        String textToSend = "POST raw text test";

        System.out.println("Текст для отправки: " + textToSend);

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(textToSend)
                .when()
                .post("/post")
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
        assertThat(url).isEqualTo("https://postman-echo.com/post");

        String contentTypeHeader = response.jsonPath().getString("headers.content-type");
        assertThat(contentTypeHeader).contains("text/plain");
        System.out.println("Хэдер Content-Type — " + contentTypeHeader);
    }
}