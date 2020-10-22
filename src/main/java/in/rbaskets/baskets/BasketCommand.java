package in.rbaskets.baskets;

import api.Endpoints;
import api.HTTPMethods;
import in.rbaskets.baskets.request.BasketModel;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class BasketCommand {
    @Step ("Создаем новую корзину с именем: {basketName}")
    public static String createBasket(String basketName, BasketModel basket) {
        ValidatableResponse response = HTTPMethods.post(Endpoints.BASKETS + basketName, basket);
        response.statusCode(201);
        return response.extract().response().jsonPath().getString("token");
    }
    @Step ("Получаем корзину по имени {basketName}")
    public static BasketModel getBasket(String token, String basketName) {
        ValidatableResponse response = HTTPMethods.get(token, Endpoints.BASKETS + basketName);
        response.statusCode(200);
        return response.extract().as(BasketModel.class);
    }
    @Step ("Обновляем корзину {basketName}")
    public static void updateBasket(String token, String basketName, BasketModel newBasket) {
        ValidatableResponse response = HTTPMethods.put(token, Endpoints.BASKETS + basketName, newBasket);
        response.statusCode(204);
    }

    @Step ("Удаляем корзину по имени: {basketName}")
    public static void deleteBasket(String token, String basketName) {
        ValidatableResponse response = HTTPMethods.delete(token, Endpoints.BASKETS + basketName);
        response.statusCode(204);
    }
    @Step ("Получаем не существующую корзину по имени {basketName}")
    public static void getNonExistingBasket(String token, String basketName) {
        ValidatableResponse response = HTTPMethods.get(token, Endpoints.BASKETS + basketName);
        response.statusCode(404);
        response.extract().body().toString();
    }
}
