import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void Hero_instantiates_true() {
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        assertEquals(true, testHero instanceof Hero);
    }

    @Test
    public void Hero_heroName_isString() {
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        assertEquals("Zeus", testHero.getmJina());
    }

    @Test
    public void Hero_
}