package game;

import game.gameRule.IGameRule;
import game.gameRule.RuleFactory;
import game.gameWeapons.GameWeapon;
import org.junit.Test;
import player.Player;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

/**
 *
 * @author escopelliti
 */
public class RockScissorsPaperTest {

    @Test
    public void testPaperVsRock() {

        IGameRule rockVsPaperRule = RuleFactory.createRule("Rock vs Paper", RockPaperScissorsFactory.ROCK,
                                           RockPaperScissorsFactory.PAPER, RockPaperScissorsFactory.PAPER);
        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        gameRules.add(rockVsPaperRule);
        List<GameWeapon> weaponList = new ArrayList<GameWeapon>();
        weaponList.add(RockPaperScissorsFactory.PAPER);
        weaponList.add(RockPaperScissorsFactory.ROCK);
        ConsoleBasedGameUIManager gameUIManager = new ConsoleBasedGameUIManager();
        Game game = new Game("RockScissorsPaper", gameUIManager, gameRules, weaponList);
        GameRound newGameRound1 = createMock(GameRound.class);
        expect(newGameRound1.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.ROCK);
        GameRound newGameRound2 = createMock(GameRound.class);
        Player player1 = new Player();
        player1.setPlayerName("Daniel");
        expect(newGameRound2.getRoundPlayer()).andReturn(player1);
        expect(newGameRound2.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.PAPER);
        replay(newGameRound1, newGameRound2);

        game.getWinner(newGameRound1, newGameRound2);
        verify(newGameRound1, newGameRound2);
    }

    @Test
    public void testScissorsVsRock() {

        IGameRule rockVsPaperRule = RuleFactory.createRule("Rock vs Scissors", RockPaperScissorsFactory.ROCK,
                                            RockPaperScissorsFactory.SCISSORS, RockPaperScissorsFactory.ROCK);
        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        gameRules.add(rockVsPaperRule);
        List<GameWeapon> weaponList = new ArrayList<GameWeapon>();
        weaponList.add(RockPaperScissorsFactory.SCISSORS);
        weaponList.add(RockPaperScissorsFactory.ROCK);
        ConsoleBasedGameUIManager gameUIManager = new ConsoleBasedGameUIManager();
        Game game = new Game("RockScissorsPaper", gameUIManager, gameRules, weaponList);
        Player player1 = new Player();
        player1.setPlayerName("Peter");
        GameRound newGameRound1 = createMock(GameRound.class);
        expect(newGameRound1.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.ROCK);
        expect(newGameRound1.getRoundPlayer()).andReturn(player1);
        GameRound newGameRound2 = createMock(GameRound.class);
        expect(newGameRound2.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.SCISSORS);
        replay(newGameRound1, newGameRound2);

        game.getWinner(newGameRound1, newGameRound2);
        verify(newGameRound1, newGameRound2);
    }

    @Test
    public void testScissorsVsScissors() {

        IGameRule rockVsPaperRule = RuleFactory.createRule("Rock vs Scissors", RockPaperScissorsFactory.SCISSORS,
                RockPaperScissorsFactory.SCISSORS);
        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        gameRules.add(rockVsPaperRule);
        List<GameWeapon> weaponList = new ArrayList<GameWeapon>();
        weaponList.add(RockPaperScissorsFactory.SCISSORS);
        weaponList.add(RockPaperScissorsFactory.SCISSORS);
        ConsoleBasedGameUIManager gameUIManager = new ConsoleBasedGameUIManager();
        Game game = new Game("RockScissorsPaper", gameUIManager, gameRules, weaponList);
        GameRound newGameRound1 = createMock(GameRound.class);
        expect(newGameRound1.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.SCISSORS);
        GameRound newGameRound2 = createMock(GameRound.class);
        expect(newGameRound2.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.SCISSORS);
        replay(newGameRound1, newGameRound2);

        game.getWinner(newGameRound1, newGameRound2);
        verify(newGameRound1, newGameRound2);
    }

    @Test
    public void testPaperVsScissors() {

        IGameRule rockVsPaperRule = RuleFactory.createRule("Rock vs Scissors", RockPaperScissorsFactory.SCISSORS,
                RockPaperScissorsFactory.PAPER, RockPaperScissorsFactory.SCISSORS);
        ArrayList<IGameRule> gameRules = new ArrayList<IGameRule>();
        gameRules.add(rockVsPaperRule);
        List<GameWeapon> weaponList = new ArrayList<GameWeapon>();
        weaponList.add(RockPaperScissorsFactory.PAPER);
        weaponList.add(RockPaperScissorsFactory.SCISSORS);
        ConsoleBasedGameUIManager gameUIManager = new ConsoleBasedGameUIManager();
        Game game = new Game("RockScissorsPaper", gameUIManager, gameRules, weaponList);
        GameRound newGameRound1 = createMock(GameRound.class);
        expect(newGameRound1.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.PAPER);
        Player player1 = new Player();
        player1.setPlayerName("Gabriel");
        GameRound newGameRound2 = createMock(GameRound.class);
        expect(newGameRound2.getPlayedWeapon()).andReturn(RockPaperScissorsFactory.SCISSORS);
        expect(newGameRound2.getRoundPlayer()).andReturn(player1);
        replay(newGameRound1, newGameRound2);

        game.getWinner(newGameRound1, newGameRound2);
        verify(newGameRound1, newGameRound2);
    }

}

