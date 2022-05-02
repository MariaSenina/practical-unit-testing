package chapter4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FootballTeamTest {
    @Test
    public void constructorShouldSetGamesWon() {
        FootballTeam team = new FootballTeam(3);

        assertEquals(3, team.getGamesWon());
    }
}
