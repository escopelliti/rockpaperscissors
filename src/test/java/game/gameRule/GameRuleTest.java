package game.gameRule;

import junit.framework.Assert;
import org.junit.Test;

import static game.GameTestingUtils.*;

/**
 *
 * @author escopelliti
 *
 */
public class GameRuleTest {

    @Test
    public void testMatchesRule_WithWrongWeapons() {

        IGameRule IGameRule;

        IGameRule = RuleFactory.createRule("Test Rule", WEAPON_1, WEAPON_2, WEAPON_1);

        boolean result = IGameRule.matchesRule(WEAPON_2, WEAPON_3);
        Assert.assertEquals("Rule shouldn't match",false, result);

        boolean reversedResult = IGameRule.matchesRule(WEAPON_3, WEAPON_2);
        Assert.assertEquals("Reversed rule shouldn't match",false, reversedResult);
    }

    @Test
    public void testMatchesRule_WithRightGameRule() {

        IGameRule IGameRule;

        IGameRule = RuleFactory.createRule("Test Rule", WEAPON_1, WEAPON_2, WEAPON_1);

        boolean result = IGameRule.matchesRule(WEAPON_1, WEAPON_2);
        Assert.assertEquals("Rule should match", true, result);

        boolean reversedResult = IGameRule.matchesRule(WEAPON_2, WEAPON_1);
        Assert.assertEquals("Reversed rule should match", true, reversedResult);
    }
}