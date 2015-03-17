import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author escopelliti
 *
 */

public class CompareToTest {


    @Test
    public void testCompareTo_secondIsGreaterThanFirst() {
        Integer first = 2;
        Integer second = 3;

        int compareResult = first.compareTo(second);

        Assert.assertTrue(compareResult <0);
    }

    @Test
    public void testCompareTo_firstIsGreaterThanSecond() {

        Integer first = 3;
        Integer second = 2;

        int compareResult = first.compareTo(second);

        Assert.assertTrue(compareResult > 0);
    }

    @Test
    public void testCompareTo_firstIsEqualsToSecond() {

        Integer first = 2;
        Integer second = 2;

        int compareResult = first.compareTo(second);

        Assert.assertEquals(0,compareResult);
    }
}
