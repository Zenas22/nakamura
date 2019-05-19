import org.junit.After;

import org.junit.*;
import org.junit.Assert.*;

public class SquadTest {

    @Test
    public void Hero_instantiates_true() {
        Squad testSquad = new Squad("Olympus", 5, "Fight the titans");
        assertEquals(true, testSquad instanceof Squad);
    }
}