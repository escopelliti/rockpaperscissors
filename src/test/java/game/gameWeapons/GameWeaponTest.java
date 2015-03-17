package game.gameWeapons;

import junit.framework.Assert;
import org.junit.Test;


/**
 *
 * @author escopelliti
 *
 */
public class GameWeaponTest {

    @Test
    public void testEquals_WithSameWeapon() {

        GameWeapon weapon1, weapon2;

        weapon1 = GameWeapon.createWeapon("rock");
        weapon2 = GameWeapon.createWeapon("rock");

        boolean flag = weapon1.equals(weapon2);

        Assert.assertEquals(true,flag);
    }

    @Test
    public void testEquals_WithDifferentWeapon() {

        GameWeapon weapon1, weapon2;

        weapon1 = GameWeapon.createWeapon("scissors");
        weapon2 = GameWeapon.createWeapon("paper");

        boolean flag = weapon2.equals(weapon1);

        Assert.assertEquals(false, flag);
    }

    @Test
    public void testCreateWeapon() {

        GameWeapon weapon = GameWeapon.createWeapon("scissors");
        Assert.assertNotNull(weapon);
    }
}
