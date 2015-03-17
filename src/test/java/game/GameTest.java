package game;

import game.gameRule.IGameRule;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static game.GameTestingUtils.WEAPONS_LIST;
import static game.GameTestingUtils.WEAPON_3;
import static org.easymock.EasyMock.*;

/**
 *
 * @author escopelliti
 *
 */
public class GameTest {

    @Test
    public void testCreateNewGameRound_GameRoundIsCorrectlyCreated() {

        GameUIManager gameUIManager = createMock(GameUIManager.class);
        expect(gameUIManager.acquirePlayerName()).andReturn("Ciccio");
        expect(gameUIManager.acquirePlayerWeapon()).andReturn(WEAPON_3);
        ArrayList<IGameRule> gameRules = createMock(ArrayList.class);
        replay(gameRules, gameUIManager);

        Game game = new Game("SUPER MARIO", gameUIManager, gameRules, WEAPONS_LIST);
        GameRound gameRound = game.createNewGameRound();
        Assert.assertNotNull(gameRound);
        Assert.assertSame(WEAPON_3, gameRound.getPlayedWeapon());
        Assert.assertSame("Ciccio", gameRound.getRoundPlayer().getPlayerName());
        verify(gameRules, gameUIManager);
    }
}
