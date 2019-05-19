import org.junit.*;
import org.junit.After;
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
    public void Hero_heroAge_isInt() {
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        assertEquals(24, testHero.getmMiaka());
    }

    @Test
    public void Hero_heroStrength_isString() {
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        assertEquals("God of Lightning", testHero.getmStrength());
    }

    @Test
    public void Hero_heroWeakness_isString() {
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        assertEquals("Cheats on Hera a lot", testHero.getmWeakness());
    }

    @Test
    public void Hero_heroId_retrievesTheId() {
        Hero.clear();
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        assertEquals(1, testHero.getmId());
    }

    @Test
    public void Hero_clear_0() {
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        Hero.clear();
        assertEquals(0, testHero.getHeroes().size());
    }

    @Test
    public void Hero_getHeroes_true() {
        Hero.clear();
        Hero oneHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        Hero twoHero = new Hero("Hades", 29, "God of The Underworld", "Zeus");
        Hero threeHero = new Hero("Poseidon", 25, "God of the Seas", "Shy");
        assertEquals(true, Hero.getHeroes().contains(oneHero));
        assertEquals(true, Hero.getHeroes().contains(twoHero));
        assertEquals(true, Hero.getHeroes().contains(threeHero));
    }
}