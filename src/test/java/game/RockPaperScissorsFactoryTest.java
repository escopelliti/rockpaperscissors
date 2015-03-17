package game;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author escopelliti
 *
 */
public class RockPaperScissorsFactoryTest {

    @Test
    public void testCreateGame_GameIsNotNull() {

        Game game = RockPaperScissorsFactory.createGame();
        Assert.assertNotNull(game);
    }
}
