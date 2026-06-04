import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DELETE text/plain")
public class DeleteRequestTest {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("DELETE text/plain запрос - проверка кода ответа и отправленного текста")
    public void deleteTextPlainTest() {
        // Текст, который мы отправим в теле DELETE запроса
        String textToSend = "Text for DELETE method to work with";

        System.out.println("📤 Отправляем DELETE запрос с типом text/plain:");
        System.out.println("Текст: " + textToSend);
        System.out.println();

        // 1. Выполняем DELETE запрос с text/plain
        Response response = given()
                .header("Content-Type", "text/plain")
                .body(textToSend)
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode, "Ожидается статус ответа 200");
        System.out.println("Код ответа: " + statusCode);

        String actualData = response.jsonPath().getString("data");
        assertThat(actualData).isEqualTo(textToSend);

        assertThat(actualData).isEqualTo(textToSend);
        System.out.println("Поле data содержит: " + actualData);

        String url = response.jsonPath().getString("url");
        assertThat(url).isEqualTo("https://postman-echo.com/delete");

        String contentType = response.jsonPath().getString("headers.content-type");
        assertThat(contentType).contains("text/plain");
        System.out.println("Хэдер Content-Type: " + contentType);
    }
}