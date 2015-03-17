package game.gameRule;

import game.gameWeapons.GameWeapon;

import java.util.ArrayList;

/**
 *
 * @author escopelliti
 *
 */
public class RuleFactory {

    public static IGameRule createRule(String description, GameWeapon weapon1, GameWeapon weapon2, GameWeapon winnerWeapon) {

        IGameRule newRule;
        ArrayList<GameWeapon> ruleWeapons;

        ruleWeapons = new ArrayList<GameWeapon>(2);
        ruleWeapons.add(weapon1);
        ruleWeapons.add(weapon2);
        newRule = new GameRule(description, ruleWeapons, winnerWeapon);
        return newRule;
    }

    public static IGameRule createRule(String description, GameWeapon weapon1, GameWeapon weapon2) {

        IGameRule newRule;
        ArrayList<GameWeapon> ruleWeapons;

        ruleWeapons = new ArrayList<GameWeapon>(2);
        ruleWeapons.add(weapon1);
        ruleWeapons.add(weapon2);
        newRule = new GameRule(description, ruleWeapons);
        return newRule;
    }
}
