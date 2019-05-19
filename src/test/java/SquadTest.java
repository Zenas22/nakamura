import org.junit.After;

import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

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
}