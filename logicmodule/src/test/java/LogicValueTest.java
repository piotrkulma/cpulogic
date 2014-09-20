import logic.LogicValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 20.09.14.
 */
public class LogicValueTest {
    private LogicValue lv = new LogicValue();

    @Test
    public void logicValueTest() {
        lv.setValue(0);
        Assert.assertEquals(0, lv.getValue());

        lv.setValue(1);
        Assert.assertEquals(1, lv.getValue());
    }

    @Test(expected=RuntimeException.class)
    public void setBadLogicValue01() {
        lv.setValue(-1);
    }

    @Test(expected=RuntimeException.class)
    public void setBadLogicValue02() {
        lv.setValue(2);
    }
}
