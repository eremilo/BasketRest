package api;

import helper.Property;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class HTTPMethods {
    static final Logger logger = Logger.getLogger(HTTPMethods.class);
    static String BaseUrl = Property.getPropByKey("baseUrl");
    static ValidatableResponse response;
    public static final HTTPMethods INSTANCE = new HTTPMethods();

    private HTTPMethods() {
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setBaseUri(BaseUrl).
                addFilter(new AllureRestAssured()).
                setContentType(ContentType.JSON).
                build();
    }

    /**
     * @param urlPath - конечный адрес для get запроса
     * @return - возвращает ответ ValidatableResponse от сервера
     */
    public static ValidatableResponse get(String token, String urlPath) {
        response = given().

                header("Authorization", token).
                get(urlPath).
                then();
        String responseBody = response.extract().asString();
        logger.info("GetResponse URL: " + BaseUrl + urlPath);
        logger.info("GetResponse BODY: " + responseBody);
        return response;
    }

    /**
     * @param urlPath - конечный адрес для post запроса
     * @param body    - тело запроса
     * @return - возвращает ответ ValidatableResponse от сервера
     */
    public static ValidatableResponse post(String urlPath, Object body) {
        response = given().
                body(body).
                post(urlPath).
                then();
        String responseBody = response.extract().asString();
        logger.info("PostResponse URL: " + BaseUrl + urlPath);
        logger.info("PostResponse BODY: " + responseBody);
        return response;
    }

    /**
     * @param urlPath - конечный адрес для put запроса
     * @param body    - тело запроса
     * @return - возвращает ответ ValidatableResponse от сервера
     */
    public static ValidatableResponse put(String token, String urlPath, Object body) {
        response = given().
                header("Authorization", token).
                body(body).
                put(urlPath).
                then();
        String responseBody = response.extract().asString();
        logger.info("PutResponse URL: " + BaseUrl + urlPath);
        logger.info("PutResponse BODY: " + responseBody);
        return response;
    }

    /**
     * @param urlPath - конечный адрес для delete запроса
     */
    public static ValidatableResponse delete(String token, String urlPath) {
        response = given().
                header("Authorization", token).
                delete(urlPath).
                then();
        String responseBody = response.extract().asString();
        logger.info("DeleteResponse URL: " + BaseUrl + urlPath);
        logger.info("DeleteResponse BODY: " + responseBody);
        return response;
    }
}
