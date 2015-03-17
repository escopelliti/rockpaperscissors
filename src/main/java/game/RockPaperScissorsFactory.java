package game;

import game.gameRule.IGameRule;
import game.gameRule.RuleFactory;
import game.gameWeapons.GameWeapon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author escopelliti
 *
 */
public class RockPaperScissorsFactory {

    public static Game createGame() {

        Game rockPaperScissors;
        List<GameWeapon> gameWeapons = createGameWeapons();
        ArrayList<IGameRule> IGameRules = createGameRules();

        rockPaperScissors = new Game("RockPaperScissors", new ConsoleBasedGameUIManager(), IGameRules, gameWeapons);
        return rockPaperScissors;
    }

    private static List<GameWeapon> createGameWeapons() {

        ArrayList<GameWeapon> gameWeapons = new ArrayList<GameWeapon>();
        gameWeapons.add(ROCK);
        gameWeapons.add(SCISSORS);
        gameWeapons.add(PAPER);
        return gameWeapons;
    }

    private static ArrayList<IGameRule> createGameRules() {

        ArrayList<IGameRule> gameRules;

        gameRules = new ArrayList<IGameRule>(6);
        IGameRule RockVsScissorsRule, ScissorsVsPaperRule, PaperVsRockRule, RockVsRockRule,
                 ScissorsVsScissorsRule,PaperVsPaperRule;
        RockVsScissorsRule = RuleFactory.createRule("Rock beats Scissors", ROCK, SCISSORS, ROCK);
        ScissorsVsPaperRule = RuleFactory.createRule("Scissors beats Paper", PAPER, SCISSORS, SCISSORS);
        PaperVsRockRule = RuleFactory.createRule("Paper beats Rock",PAPER,ROCK,PAPER);
        RockVsRockRule = RuleFactory.createRule("Rock ties Rock", ROCK, ROCK);
        ScissorsVsScissorsRule = RuleFactory.createRule("Scissors ties Scissors", SCISSORS, SCISSORS);
        PaperVsPaperRule = RuleFactory.createRule("Paper ties Paper", PAPER, PAPER);

        gameRules.add(RockVsScissorsRule);
        gameRules.add(ScissorsVsPaperRule);
        gameRules.add(PaperVsRockRule);
        gameRules.add(RockVsRockRule);
        gameRules.add(ScissorsVsScissorsRule);
        gameRules.add(PaperVsPaperRule);
        return gameRules;
    }

    public static final GameWeapon ROCK = new GameWeapon("rock");
    public static final GameWeapon SCISSORS = new GameWeapon("scissors");
    public static final GameWeapon PAPER = new GameWeapon("paper");
}
