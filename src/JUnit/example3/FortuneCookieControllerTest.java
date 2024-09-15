package JUnit.example3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieControllerTest {
    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    @BeforeAll
    public static void createController() {
        FortuneCookieFactory positiveFactory = new FortuneCookieFactory(
                new FortuneConfig(true),
                singletonList("positive"),
                singletonList("negative")
        );

        FortuneCookieFactory negativeFactory = new FortuneCookieFactory(
                new FortuneConfig(false),
                singletonList("positive"),
                singletonList("negative")
        );

        goodFactoryController = new FortuneCookieController(positiveFactory);
        badFactoryController = new FortuneCookieController(negativeFactory);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        Assertions.assertEquals("positive", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        Assertions.assertEquals("negative", badFactoryController.tellFortune().getFortuneText());
    }
}
