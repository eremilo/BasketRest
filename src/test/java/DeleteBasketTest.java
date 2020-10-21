import in.rbaskets.baskets.BasketCommand;
import in.rbaskets.baskets.request.BasketModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Супер новый функционал")
@Feature("Удаление")
public class DeleteBasketTest {
    public String basketName = RandomStringUtils.randomAlphabetic(6);
    public String token;

    BasketModel basket = new BasketModel
            .Builder()
            .forwardUrl("https://google.com")
            .capacity(300)
            .expandPath(true)
            .insecureTls(true)
            .proxyResponse(true)
            .build();

    @BeforeClass(description = "создаем корзину, получаем токен")
    public void setUp() {
        token = BasketCommand.createBasket(basketName, basket);
    }

    @Test(description = "удаляем корзину, проверяем ответ")
    public void deleteBasket() {
        BasketCommand.deleteBasket(token, basketName);
        BasketCommand.getNonExistingBasket(token, basketName);
    }
}

