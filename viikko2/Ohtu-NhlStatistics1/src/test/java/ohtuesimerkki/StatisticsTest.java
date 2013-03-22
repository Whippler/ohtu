/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lammenoj
 */
public class StatisticsTest {

    Statistics stats;
    List<Player> pelaajat;
    
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    public StatisticsTest() {
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
        pelaajat = readerStub.getPlayers();
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        Player expResult = pelaajat.get(2);
        Player result = stats.search("Kurri");

        assertEquals(expResult.getGoals(), result.getGoals());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPoints(), result.getPoints());
        assertEquals(expResult.getTeam(), result.getTeam());
        assertNull(stats.search("sda"));
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        List<Player> expResult = stats.team("DET");
        Player pelaaja = expResult.get(0);

        assertEquals("Yzerman", pelaaja.getName());
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        List expResult = null;
        Player result = stats.topScorers(1).get(0);
        assertEquals("Gretzky", result.getName());
    }
}
