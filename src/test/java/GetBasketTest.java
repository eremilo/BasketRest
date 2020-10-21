import in.rbaskets.baskets.BasketCommand;
import in.rbaskets.baskets.request.BasketModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Супер новый функционал")
@Feature("Получение")
public class GetBasketTest extends BaseBasket {
    @Test(description = "Получаем корзину с данными проверяем, что она равна созданной")
    public void getBasket() {
        BasketModel expectedBasket = BasketCommand.getBasket(token, basketName);
        assertThat(basket).isEqualToComparingFieldByField(expectedBasket);
    }
}
