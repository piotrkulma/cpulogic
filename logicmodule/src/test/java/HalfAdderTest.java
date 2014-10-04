import cpu.alu.adder.HalfAdder;
import logic.LogicValue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by root on 20.09.14.
 */
public class HalfAdderTest {
    private LogicValue a = new LogicValue(0);
    private LogicValue b = new LogicValue(0);

    private HalfAdder ha = new HalfAdder(a, b);

    @Test
    public void adderTest() {
        setLogicValues(0, 0);
        Assert.assertEquals(0, ha.getOutput().getValue());

        setLogicValues(0, 1);
        Assert.assertEquals(1, ha.getOutput().getValue());

        setLogicValues(1, 0);
        Assert.assertEquals(1, ha.getOutput().getValue());

        setLogicValues(1, 1);
        Assert.assertEquals(0, ha.getOutput().getValue());
    }

    @Test
    public void adderCarryTest() {
        setLogicValues(0, 0);
        Assert.assertEquals(0, ha.getCarryOutput().getValue());

        setLogicValues(0, 1);
        Assert.assertEquals(0, ha.getCarryOutput().getValue());

        setLogicValues(1, 0);
        Assert.assertEquals(0, ha.getCarryOutput().getValue());

        setLogicValues(1, 1);
        Assert.assertEquals(1, ha.getCarryOutput().getValue());
    }

    @Ignore
    public void setLogicValues(int _a, int _b) {
        a.setValue(_a);
        b.setValue(_b);

        ha.refresh(a, b);
    }
}
