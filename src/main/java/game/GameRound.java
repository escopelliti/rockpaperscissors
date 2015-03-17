package game;

import game.gameWeapons.GameWeapon;
import player.Player;

/**
 *
 * @author escopelliti
 *
 */
public class GameRound {

    public GameRound(Player player, GameWeapon playedWeapon) {

        this.roundPlayer = player;
        this.playedWeapon = playedWeapon;
    }

    public GameWeapon getPlayedWeapon() {
        return this.playedWeapon;
    }

    public Player getRoundPlayer() {
        return roundPlayer;
    }

    private GameWeapon playedWeapon;
    private Player roundPlayer;
}
