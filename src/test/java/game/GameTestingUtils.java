package game;

import game.gameWeapons.GameWeapon;

import java.util.ArrayList;

/**
 *
 * @author escopelliti
 *
 */
public class GameTestingUtils {

    public static GameWeapon WEAPON_1 = GameWeapon.createWeapon("weapon1");

    public static GameWeapon WEAPON_2 = GameWeapon.createWeapon("weapon2");

    public static GameWeapon WEAPON_3 = GameWeapon.createWeapon("weapon3");

    public static ArrayList<GameWeapon> WEAPONS_LIST = new ArrayList<GameWeapon>() {{
        add(WEAPON_1);
        add(WEAPON_2);
        add(WEAPON_3);
    }};
}
