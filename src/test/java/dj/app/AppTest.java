package dj.app;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SuppressWarnings("WeakerAccess")
public class AppTest {
    @Test
    public void getGreetingReturnsCorrectGreeting() {
        App unit = new App();
        assertThat(unit.getDefaultName(), is("world"));
    }
}
