import alu.adder.FullAdder;
import alu.subtractor.FullSubtractor;
import logic.LogicValue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 20.09.14.
 */
public class FullAdderTest {
    private LogicValue a = new LogicValue(0);
    private LogicValue b = new LogicValue(0);
    private LogicValue cin = new LogicValue(0);

    private FullAdder fa = new FullAdder(cin, a, b);

    @Test
    public void fullAdderTest() {
        setLogicValues(0, 0, 0);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(1, 0, 0);
        Assert.assertEquals(1, fa.getOutput().getValue());

        setLogicValues(0, 1, 0);
        Assert.assertEquals(1, fa.getOutput().getValue());

        setLogicValues(1, 1, 0);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(0, 0, 1);
        Assert.assertEquals(1, fa.getOutput().getValue());

        setLogicValues(1, 0, 1);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(0, 1, 1);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(1, 1, 1);
        Assert.assertEquals(1, fa.getOutput().getValue());
    }

    @Test
    public void fullAdderCarryTest() {
        setLogicValues(0, 0, 0);
        Assert.assertEquals(0, fa.getCarryOutput().getValue());

        setLogicValues(1, 0, 0);
        Assert.assertEquals(0, fa.getCarryOutput().getValue());

        setLogicValues(0, 1, 0);
        Assert.assertEquals(0, fa.getCarryOutput().getValue());

        setLogicValues(1, 1, 0);
        Assert.assertEquals(1, fa.getCarryOutput().getValue());

        setLogicValues(0, 0, 1);
        Assert.assertEquals(0, fa.getCarryOutput().getValue());

        setLogicValues(1, 0, 1);
        Assert.assertEquals(1, fa.getCarryOutput().getValue());

        setLogicValues(0, 1, 1);
        Assert.assertEquals(1, fa.getCarryOutput().getValue());

        setLogicValues(1, 1, 1);
        Assert.assertEquals(1, fa.getCarryOutput().getValue());
    }

    @Ignore
    public void setLogicValues(int _a, int _b, int _cin) {
        a.setValue(_a);
        b.setValue(_b);
        cin.setValue(_cin);
    }
}
