package chapter4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {
    // Constants
    private static final int ANY_NUMBER = 123;

    // Argument generator methods
    public Object[] illegalNumOfGamesWon() {
        return new Object[] {-10, -1};
    }

    public Object[] numOfGamesWon() {
        return new Integer [] {0, 1, 2};
    }

    // Test methods
    @Test
    @Parameters(method = "numOfGamesWon")
    public void constructorShouldSetGamesWon(int numOfGamesWon) {
        FootballTeam team = new FootballTeam(numOfGamesWon);

        assertEquals(numOfGamesWon + " games passed to constructor, " +
                        "but " + team.getGamesWon() + " were returned",
                numOfGamesWon, team.getGamesWon());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNumOfGamesWon")
    public void constructorShouldThrowIllegalArgumentExceptionForIllegalNumOfGamesWon(int numOfGamesWon) {
        new FootballTeam(numOfGamesWon);
    }

    @Test
    public void shouldBePossibleToCompareTeams() {
        FootballTeam team = new FootballTeam(ANY_NUMBER);

        assertTrue("Football tam should implement Comparable", team instanceof Comparable);
    }
}
