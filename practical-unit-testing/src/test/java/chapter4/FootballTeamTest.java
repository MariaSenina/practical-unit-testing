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
    private static final int TWO_GAMES_WON = 2;
    private static final int THREE_GAMES_WON = 3;

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

    @Test
    public void teamsWithMoreGamesWonShouldBeGreater() {
        FootballTeam team_2 = new FootballTeam(TWO_GAMES_WON);
        FootballTeam team_3 = new FootballTeam(THREE_GAMES_WON);

        assertTrue("Team with " + team_3.getGamesWon() + " games won should be ranked " +
                        "higher than the team with " + team_2.getGamesWon() + " games won",
                team_3.compareTo(team_2) > 0);
    }

    @Test
    public void teamsWithLessGamesWonShouldBeLesser() {
        FootballTeam team_2 = new FootballTeam(TWO_GAMES_WON);
        FootballTeam team_3 = new FootballTeam(THREE_GAMES_WON);

        assertTrue("Team with " + team_2.getGamesWon() + " games won should be ranked " +
                        "lower than the team with " + team_3.getGamesWon() + " games won",
                team_2.compareTo(team_3) < 0);
    }

    @Test
    public void teamsWithEqualNumberOfGamesWonShouldBeEqual() {
        FootballTeam teamA = new FootballTeam(TWO_GAMES_WON);
        FootballTeam teamB = new FootballTeam(TWO_GAMES_WON);

        assertTrue("Both teams won the same number of games: " +
                        teamA.getGamesWon() + " should equal " + teamB.getGamesWon(),
                teamA.compareTo(teamB) == 0);
    }
}
