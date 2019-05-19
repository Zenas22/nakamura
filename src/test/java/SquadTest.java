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
}