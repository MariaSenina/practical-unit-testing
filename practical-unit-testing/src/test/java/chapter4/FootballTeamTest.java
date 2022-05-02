package chapter4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest {

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

    public Object[] illegalNumOfGamesWon() {
        return new Object[] {-10, -1};
    }

    public Object[] numOfGamesWon() {
        return new Integer [] {0, 1, 2};
    }
}
