package game.gameEngine;

import game.GameRound;
import game.gameRule.IGameRule;
import game.gameWeapons.GameWeapon;
import player.Player;

import java.util.List;

/**
 *
 * @author escopelliti
 *
 */
public class DefaultGameEngine implements GameEngine {

    public DefaultGameEngine(List<IGameRule> IGameRules){

        this.IGameRules = IGameRules;
    }

    @Override
    public Player getWinner(GameRound round1, GameRound round2) {

        GameWeapon weapon1, weapon2;
        IGameRule selectedRule;
        GameWeapon winnerWeapon;

        weapon1 = round1.getPlayedWeapon();
        weapon2 = round2.getPlayedWeapon();
        selectedRule = selectRule(weapon1, weapon2);
        winnerWeapon = selectedRule.getWinnerWeapon();
        try {
            if(weapon1.equals(winnerWeapon)) {
                return round1.getRoundPlayer();
            }
            else {
                return round2.getRoundPlayer();
            }
        } catch (NullPointerException ex) {
            return null;
        }
    }

    @Override
    public boolean hasWinner(GameWeapon winnerWeapon) {

        if(winnerWeapon == null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public IGameRule selectRule(GameWeapon weapon1, GameWeapon weapon2) {

        int count = 0;
        IGameRule selectedRule = null;
        while (count < this.IGameRules.size()) {

            IGameRule currentRule = this.IGameRules.get(count);

            if (currentRule.matchesRule(weapon1, weapon2)) {
                selectedRule = currentRule;
                break;
            }
            count++;
        }
        return selectedRule;
    }

    private List<IGameRule> IGameRules;
}
