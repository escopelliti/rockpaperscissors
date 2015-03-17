package game.gameWeapons;

/**
 *
 * @author escopelliti
 *
 */
public class GameWeapon {

    public GameWeapon(String weaponName) {

        this.weaponName = weaponName;
    }

    public boolean equals(GameWeapon gameWeapon) {

        if(this.weaponName.equals(gameWeapon.getWeaponName())) {
            return true;
        }
        else {
            return false;
        }
    }

    public static GameWeapon createWeapon(String weaponName) {

        GameWeapon gameWeapon = new GameWeapon(weaponName);
        return gameWeapon;
    }

    public String getWeaponName() {

        return this.weaponName;
    }

    private String weaponName;
}
