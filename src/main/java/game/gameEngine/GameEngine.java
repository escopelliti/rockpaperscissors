package game.gameEngine;

import game.GameRound;
import game.gameRule.IGameRule;
import game.gameWeapons.GameWeapon;
import player.Player;

/**
 *
 * @author escopelliti
 *
 */
public interface GameEngine {

    public Player getWinner(GameRound round1, GameRound round2);
    public IGameRule selectRule(GameWeapon weapon1, GameWeapon weapon2);
    public boolean hasWinner(GameWeapon winnerWeapon);

}
