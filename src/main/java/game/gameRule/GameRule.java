package game.gameRule;


import game.gameWeapons.GameWeapon;

import java.util.ArrayList;

/**
 *
 * @author escopelliti
 *
 */
public class GameRule implements IGameRule {

    public GameRule(String ruleName, ArrayList<GameWeapon> ruleWeapons, GameWeapon winner) {

        this.ruleName = ruleName;
        this.ruleWeapons = ruleWeapons;
        this.winnerWeapon = winner;
    }

    public GameRule(String ruleName, ArrayList<GameWeapon> ruleWeapons) {

        this.ruleName = ruleName;
        this.ruleWeapons = ruleWeapons;
    }

    @Override
    public boolean matchesRule(GameWeapon weapon1, GameWeapon weapon2) {

        GameWeapon ruleWeapon_1, ruleWeapon_2;

        ruleWeapon_1 = this.ruleWeapons.get(0);
        ruleWeapon_2 = this.ruleWeapons.get(1);
        if(ruleWeapon_1.equals(weapon1) && ruleWeapon_2.equals(weapon2)) {
            return true;
        }
        else{
            if(ruleWeapon_1.equals(weapon2) && ruleWeapon_2.equals(weapon1)) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public GameWeapon getWinnerWeapon() {

        return this.winnerWeapon;
    }

    private GameWeapon winnerWeapon;
    private String ruleName;
    private ArrayList<GameWeapon> ruleWeapons;
}
