package game.gameEngine;

import game.GameRound;
import game.gameRule.IGameRule;
import junit.framework.Assert;
import org.junit.Test;
import player.Player;

import java.util.ArrayList;

import static game.GameTestingUtils.*;
import static org.easymock.EasyMock.*;

/**
 *
 * @author escopelliti
 *
 */
public class DefaultGameEngineTest {

    @Test
    public void testSelectRule_SelectedRuleIsNull() {


        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        IGameRule gameRule1 = createMock("gameRule1", IGameRule.class);
        gameRules.add(gameRule1);

        expect(gameRule1.matchesRule(eq(WEAPON_1), eq(WEAPON_2))).andReturn(false);

        IGameRule gameRule2 = createMock("gameRule2", IGameRule.class);
        gameRules.add(gameRule2);
        expect(gameRule2.matchesRule(WEAPON_1, WEAPON_2)).andReturn(false);

        replay(gameRule1, gameRule2);
        DefaultGameEngine gameEngine = new DefaultGameEngine(gameRules);
        IGameRule selectedRule = gameEngine.selectRule(WEAPON_1, WEAPON_2);
        Assert.assertNull(selectedRule);
        verify(gameRule1,gameRule2);
    }

    @Test
    public void testSelectRule_SelectedRuleIsNotNull() {


        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        IGameRule gameRule1 = createMock("gameRule1", IGameRule.class);
        gameRules.add(gameRule1);

        expect(gameRule1.matchesRule(eq(WEAPON_1), eq(WEAPON_2))).andReturn(false);

        IGameRule gameRule2 = createMock("gameRule2", IGameRule.class);
        gameRules.add(gameRule2);
        expect(gameRule2.matchesRule(WEAPON_1, WEAPON_2)).andReturn(true);

        replay(gameRule1, gameRule2);
        DefaultGameEngine gameEngine = new DefaultGameEngine(gameRules);
        IGameRule selectedRule = gameEngine.selectRule(WEAPON_1, WEAPON_2);
        Assert.assertNotNull(selectedRule);
        Assert.assertSame(gameRule2, selectedRule);

        verify(gameRule1,gameRule2);
    }

    @Test
    public void testGetWinner_WinnerIsNull() {

        GameRound gameRound1, gameRound2;
        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();

        IGameRule gameRule = createMock(IGameRule.class);
        gameRules.add(gameRule);
        expect(gameRule.matchesRule(WEAPON_2, WEAPON_2)).andReturn(true);
        expect(gameRule.getWinnerWeapon()).andReturn(null);

        gameRound1 = createMock(GameRound.class);
        expect(gameRound1.getPlayedWeapon()).andReturn(WEAPON_2);
        gameRound2 = createMock(GameRound.class);
        expect(gameRound2.getPlayedWeapon()).andReturn(WEAPON_2);
        replay(gameRound1, gameRound2, gameRule);

        DefaultGameEngine gameEngine = new DefaultGameEngine(gameRules);
        Player player = gameEngine.getWinner(gameRound1, gameRound2);
        Assert.assertNull(player);
        verify(gameRound1, gameRound2, gameRule);
    }

    @Test
    public void testGetWinner_WinnerIsNotNull() {

        GameRound gameRound2, gameRound1;
        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();

        IGameRule gameRule1 = createMock("gameRule1", IGameRule.class);
        gameRules.add(gameRule1);
        expect(gameRule1.matchesRule(WEAPON_3, WEAPON_1)).andReturn(true);
        expect(gameRule1.getWinnerWeapon()).andReturn(WEAPON_1);
        gameRound1 = createMock("gameRound1", GameRound.class);
        expect(gameRound1.getPlayedWeapon()).andReturn(WEAPON_3);
        gameRound2 = createMock("gameRound2", GameRound.class);
        expect(gameRound2.getPlayedWeapon()).andReturn(WEAPON_1);
        Player winnerPlayer = createMock(Player.class);
        expect(gameRound2.getRoundPlayer()).andReturn(winnerPlayer);

        replay(gameRound1, gameRound2, gameRule1, winnerPlayer);

        DefaultGameEngine gameEngine = new DefaultGameEngine(gameRules);
        Player player = gameEngine.getWinner(gameRound1, gameRound2);
        Assert.assertNotNull(player);
        Assert.assertSame(winnerPlayer, player);
        verify(gameRound1, gameRound2, gameRule1, winnerPlayer);
    }



    @Test
    public void testHasWinner_WinnerWeaponExpected() {

        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        IGameRule gameRule = createMock(IGameRule.class);
        gameRules.add(gameRule);
        DefaultGameEngine gameEngine = new DefaultGameEngine(gameRules);
        boolean result = gameEngine.hasWinner(WEAPON_1);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHasWinner_WinnerWeaponNotExpected() {

        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        IGameRule gameRule = createMock(IGameRule.class);
        gameRules.add(gameRule);
        DefaultGameEngine gameEngine = new DefaultGameEngine(gameRules);
        boolean result = gameEngine.hasWinner(null);
        Assert.assertEquals(false, result);
    }
}