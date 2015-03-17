package game.gameRule;

import game.gameWeapons.GameWeapon;
import junit.framework.Assert;
import org.junit.Test;

import static game.GameTestingUtils.*;

/**
 *
 * @author escopelliti
 *
 */
public class RuleFactoryTest {

    @Test
    public void testCreateRule_GameRuleIsNotNull() {

        IGameRule IGameRule = RuleFactory.createRule("Weapon 1 Vs Weapon 2 Rule", WEAPON_1, WEAPON_2, WEAPON_1);
        Assert.assertNotNull(IGameRule);
    }

    @Test
    public void testCreateRule_WinnerWeaponIsNull() {

        IGameRule IGameRule = RuleFactory.createRule("Weapon 3 Vs Weapon 3 Rule", WEAPON_3, WEAPON_3);
        GameWeapon winnerWeapon = IGameRule.getWinnerWeapon();
        Assert.assertNull(winnerWeapon);
    }
}
