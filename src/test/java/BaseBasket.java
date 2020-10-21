import in.rbaskets.baskets.BasketCommand;
import in.rbaskets.baskets.request.BasketModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseBasket {
    public String basketName = RandomStringUtils.randomAlphabetic(6); //генерим рандомное имя для корзины
    public String token;

    BasketModel basket = new BasketModel
            .Builder()
            .forwardUrl("https://google.com")
            .capacity(300)
            .expandPath(true)
            .insecureTls(true)
            .proxyResponse(true)
            .build();

    @BeforeClass (description = "создаем корзину, получаем токен")
    public void setUp() {
        token = BasketCommand.createBasket(basketName, basket);
    }

    @AfterClass (description = "удаляем корзину после тестов")
    public void tearDown() {
        BasketCommand.deleteBasket(token, basketName);
    }
}
