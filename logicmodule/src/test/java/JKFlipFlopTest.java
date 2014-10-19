import cpu.programcounter.JKFlipFlop;
import logic.LogicValue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 19.10.14.
 */
public class JKFlipFlopTest {
    private LogicValue j = new LogicValue(0);
    private LogicValue k = new LogicValue(0);
    private JKFlipFlop flipFlop = new JKFlipFlop(j, k, new LogicValue(0));

    @Test
    public void jkFlipFlopQTruthTableTest() {
        j = new LogicValue(0);
        k = new LogicValue(0);
        flipFlop = new JKFlipFlop(j, k, new LogicValue(0));

        setValue(0, 0, 0);
        Assert.assertEquals(0, flipFlop.getQOutput().getValue());

        setValue(1, 0, 0);
        Assert.assertEquals(1, flipFlop.getQOutput().getValue());

        setValue(0, 1, 0);
        Assert.assertEquals(0, flipFlop.getQOutput().getValue());

        setValue(1, 1, 0);
        Assert.assertEquals(0, flipFlop.getQOutput().getValue());

        setValue(1, 1, 1);
        Assert.assertEquals(1, flipFlop.getQOutput().getValue());

        setValue(1, 1, 0);
        Assert.assertEquals(0, flipFlop.getQOutput().getValue());

        setValue(1, 0, 0);
        Assert.assertEquals(1, flipFlop.getQOutput().getValue());
    }

    @Test
    public void jkFlipFlopQPrimeTruthTableTest() {
        j = new LogicValue(0);
        k = new LogicValue(0);
        flipFlop = new JKFlipFlop(j, k, new LogicValue(0));

        setValue(0, 0, 0);
        Assert.assertEquals(1, flipFlop.getQPrimeOutput().getValue());

        setValue(1, 0, 0);
        Assert.assertEquals(0, flipFlop.getQPrimeOutput().getValue());

        setValue(0, 1, 0);
        Assert.assertEquals(1, flipFlop.getQPrimeOutput().getValue());

        setValue(1, 1, 0);
        Assert.assertEquals(1, flipFlop.getQPrimeOutput().getValue());

        setValue(1, 1, 1);
        Assert.assertEquals(0, flipFlop.getQPrimeOutput().getValue());

        setValue(1, 1, 0);
        Assert.assertEquals(1, flipFlop.getQPrimeOutput().getValue());

        setValue(1, 0, 0);
        Assert.assertEquals(0, flipFlop.getQPrimeOutput().getValue());
    }

    @Ignore
    public void setValue(int _j, int _k, int _c) {
        this.j.setValue(_j);
        this.k.setValue(_k);

        flipFlop.refresh(j, k, new LogicValue(_c));
    }
}
