package game.exceptions;

/**
 *
 * @author escopelliti
 *
 */
public class InvalidWeaponException extends IllegalArgumentException {

    public InvalidWeaponException() {

        super("Not Allowed Weapon");
    }
}
