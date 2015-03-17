package game.gameRule;

import game.gameWeapons.GameWeapon;

/**
 *
 * @author escopelliti
 *
 */
public interface IGameRule {

    boolean matchesRule(GameWeapon weapon1, GameWeapon weapon2);
    GameWeapon getWinnerWeapon();
}
