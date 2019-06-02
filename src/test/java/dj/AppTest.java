package dj;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppTest {
    @Test public void getGreetingReturnsCorrectGreeting() {
        App classUnderTest = new App();
        assertThat(classUnderTest.getGreeting(), is("Hello world."));
    }
}
