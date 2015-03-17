package game;

import game.gameWeapons.GameWeapon;
import player.Player;

/**
 *
 * @author escopelliti
 *
 */
public interface GameUIManager {

    public GameWeapon acquirePlayerWeapon();
    public String acquirePlayerName();
    public void getWinner(Player winner);
}
