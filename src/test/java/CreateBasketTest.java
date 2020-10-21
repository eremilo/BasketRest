import in.rbaskets.baskets.BasketCommand;
import in.rbaskets.baskets.request.BasketModel;
import io.qameta.allure.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
@Epic("Супер новый функционал")
@Feature("Проверяем создание")
public class CreateBasketTest {
    private String basketName = RandomStringUtils.randomAlphabetic(6); //генерим рандомное имя для корзины
    private String token;

    BasketModel basket = new BasketModel
            .Builder()
            .forwardUrl("https://google.com")
            .capacity(300)
            .expandPath(true)
            .insecureTls(true)
            .proxyResponse(true)
            .build();

    @Test (description = "создаем корзину, проверяем длину токена")
    public void createBasket(){
        token = BasketCommand.createBasket(basketName, basket);
        assertThat(token).hasSize(44);
    }
}
