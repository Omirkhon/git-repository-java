package JUnit.example3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;

public class FortuneCookieFactoryTest {
    private static FortuneCookieFactory factory;

    @BeforeEach
    public void createFactory() {
        FortuneConfig config = new FortuneConfig(true);
        factory = new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        );
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        factory.bakeFortuneCookie();
        Assertions.assertEquals(1, factory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        factory.bakeFortuneCookie();
        factory.bakeFortuneCookie();
        Assertions.assertEquals(2, factory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        factory.resetCookiesCreated();
        Assertions.assertEquals(0, factory.getCookiesBaked());
    }
}
