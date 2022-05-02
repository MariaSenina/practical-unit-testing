package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FootballTeamTest {
    private static final int THREE_GAMES_WON = 3;

    @Test
    public void constructorShouldSetGamesWon() {
        FootballTeam team = new FootballTeam(THREE_GAMES_WON);

        assertEquals(THREE_GAMES_WON + " games passed to constructor, " +
                        "but " + team.getGamesWon() + " were returned",
                THREE_GAMES_WON, team.getGamesWon());
    }
}
