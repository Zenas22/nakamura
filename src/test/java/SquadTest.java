import org.junit.After;

import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

    @After
    public void tearDown() {
        Squad.clear();
    }

    @Test
    public void Squad_instantiates_true() {
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals(true, testSquad instanceof Squad);
    }

    @Test
    public void Squad_squadName_isString() {
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals("Olympus", testSquad.getmSquadName());
    }

    @Test
    public void Squad_squadSize_isInt() {
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals(5, testSquad.getmSize());
    }

    @Test
    public void Squad_squadCause_isString() {
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals("Fight the titans", testSquad.getmCause());
    }

    @Test
    public void getSquads_returnsAllSquads_true(){
        Squad oneSquad = new Squad("Olympus", 5, "Fight the titans");
        Squad twoSquad = new Squad("Suicide Squad", 3, "Badass");
        assertEquals(true, Squad.getSquads().contains(oneSquad));
        assertEquals(true, Squad.getSquads().contains(twoSquad));
    }

    @Test
    public void clear_emptiesSquad_0() {
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        Squad.clear();
        assertEquals(0, Squad.getSquads().size());
    }

    @Test
    public void Squad_getmId_returns1(){
        Squad.clear();
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals(1, testSquad.getmId());
    }

    @Test
    public void find_returnsSquadWithSameId_twoSquad() {
        Squad.clear();
        Squad oneSquad = new Squad("Olympus", 5, "Fight the titans");
        Squad twoSquad = new Squad("Suicide Squad", 3, "Badass");
        assertEquals(twoSquad, Squad.find(twoSquad.getmId()));
    }

    @Test
    public void getHeroes_returnsEmptyList_ArrayList() {
        Squad.clear();
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals(0, testSquad.getmHeroes().size());
    }

    @Test
    public void addHero_addsHeroToList_true() {
        Squad.clear();
        Squad Olympus = new Squad("Olympus", 5, "Fight the titans");
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        Olympus.addHero(testHero);
        assertTrue(Olympus.getmHeroes().contains(testHero));
    }

    @Test
    public void addHero_IfListIsFull_nothing() {
        Squad.clear();
        Squad Olympus = new Squad("Olympus", 2, "Fight the titans");
        Hero testHero = new Hero("Zeus", 24, "God of Lightning", "Cheats on Hera a lot");
        Olympus.addHero(testHero);
        Hero twoHero = new Hero("Hades", 29, "God of the underworld", "Zeus");
        Olympus.addHero(twoHero);
        Hero threeHero = new Hero("Poseidon", 25, "God of the Sea", "water");
        Olympus.addHero(threeHero);
        assertEquals(true, Olympus.getmHeroes().contains(testHero));
        assertEquals(true, Olympus.getmHeroes().contains(twoHero));
        assertEquals(false, Olympus.getmHeroes().contains(threeHero));
    }

    @Test
    public void find_returnsNullWhenNoHeroFound_null() {
        assertTrue(Squad.find(999) == null);
    }
}