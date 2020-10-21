import in.rbaskets.baskets.BasketCommand;
import in.rbaskets.baskets.request.BasketModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Супер новый функционал")
@Feature("Обновление")
public class UpdateBasketTest extends BaseBasket {

    @Test(description = "Обновляем данные корзины, проверяем что данный обновились")
    public void updateBasket() {
        BasketModel newBasket = new BasketModel
                .Builder()
                .forwardUrl("https://yandex.ru")
                .expandPath(false)
                .insecureTls(false)
                .proxyResponse(false)
                .capacity(150)
                .build();

        BasketCommand.updateBasket(token, basketName, newBasket);
        BasketModel updatedBasket = BasketCommand.getBasket(token, basketName);
        assertThat(newBasket).isEqualToComparingFieldByField(updatedBasket);
    }
}
