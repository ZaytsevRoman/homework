package org.aston.lesson16;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {
    private final String POST_TEXT = "This is expected to be sent back as part of response body.";
    private final String POST_JSON = "{\n" +
            "        \"foo1\": \"bar1\",\n" +
            "        \"foo2\": \"bar2\"\n" +
            "    }";
    private static ResponseSpecification responseSpecificationAll;
    private static ResponseSpecification responseSpecificationPostText;

    @BeforeAll
    static void setUp() {
        responseSpecificationAll = expect()
                .statusCode(200)
                .and().body("headers.x-forwarded-proto", equalTo("https"))
                .and().body("headers.x-forwarded-port", equalTo("443"))
                .and().body("headers.host", equalTo("postman-echo.com"))
                .and().body("headers.accept", equalTo("*/*"))
                .and().body("headers.user-agent", equalTo("Apache-HttpClient/4.5.13 (Java/11.0.17)"))
                .and().body("headers.accept-encoding", equalTo("gzip,deflate"));

        responseSpecificationPostText = expect()
                .and().body("data", equalTo("This is expected to be sent back as part of response body."))
                .and().body("headers.content-length", equalTo("58"))
                .and().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"));
    }

    @Test
    @DisplayName("Проверка GET запроса")
    void checkGetRequest() {
        when().get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then().log().body()
                .spec(responseSpecificationAll)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"))
                .and().body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    @DisplayName("Проверка POST запроса с текстом")
    void checkPostTextRequest() {
        given().body(POST_TEXT)
                .when().post("https://postman-echo.com/post")
                .then().log().body()
                .spec(responseSpecificationAll)
                .spec(responseSpecificationPostText)
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Проверка POST запроса с Data")
    void checkPostDataRequest() {
        given().contentType("application/json").body(POST_JSON)
                .when().post("https://postman-echo.com/post")
                .then().log().body()
                .spec(responseSpecificationAll)
                .and().body("data.foo1", equalTo("bar1"))
                .and().body("data.foo2", equalTo("bar2"))
                .and().body("headers.content-length", equalTo("54"))
                .and().body("headers.content-type", equalTo("application/json"))
                .and().body("json.foo1", equalTo("bar1"))
                .and().body("json.foo2", equalTo("bar2"))
                .and().body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    @DisplayName("Проверка PUT запроса")
    void checkPutRequest() {
        given().body(POST_TEXT)
                .when().put("https://postman-echo.com/put")
                .then().log().body()
                .spec(responseSpecificationAll)
                .spec(responseSpecificationPostText)
                .and().body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    @DisplayName("Проверка PATCH запроса")
    void checkPatchRequest() {
        given().body(POST_TEXT)
                .when().patch("https://postman-echo.com/patch")
                .then().log().body()
                .spec(responseSpecificationAll)
                .spec(responseSpecificationPostText)
                .and().body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    @DisplayName("Проверка DELETE запроса")
    void checkDeleteRequest() {
        given().body(POST_TEXT)
                .when().delete("https://postman-echo.com/delete")
                .then().log().body()
                .spec(responseSpecificationAll)
                .spec(responseSpecificationPostText)
                .and().body("url", equalTo("https://postman-echo.com/delete"));
    }
}
