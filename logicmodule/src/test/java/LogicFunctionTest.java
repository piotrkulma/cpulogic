import logic.LogicValue;
import logic.gate.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 20.09.14.
 */
public class LogicFunctionTest {
    private LogicValue a = new LogicValue(0);
    private LogicValue b = new LogicValue(0);

    private ORGate or = new ORGate(a, b);
    private NOTGate not = new NOTGate(a);
    private ANDGate and = new ANDGate(a, b);
    private NANDGate nand = new NANDGate(a, b);
    private NORGate nor = new NORGate(a, b);
    private XORGate xor = new XORGate(a, b);

    @Test
    public void andResults() {
        setInputs(0, 0);
        Assert.assertEquals(0, and.getOutput().getValue());

        setInputs(0, 1);
        Assert.assertEquals(0, and.getOutput().getValue());

        setInputs(1, 0);
        Assert.assertEquals(0, and.getOutput().getValue());

        setInputs(1, 1);
        Assert.assertEquals(1, and.getOutput().getValue());
    }

    @Test
    public void orResults() {
        setInputs(0, 0);
        Assert.assertEquals(0, or.getOutput().getValue());

        setInputs(0, 1);
        Assert.assertEquals(1, or.getOutput().getValue());

        setInputs(1, 0);
        Assert.assertEquals(1, or.getOutput().getValue());

        setInputs(1, 1);
        Assert.assertEquals(1, or.getOutput().getValue());
    }

    @Test
    public void notResults() {
        setInputA(0);
        Assert.assertEquals(1, not.getOutput().getValue());

        setInputA(1);
        Assert.assertEquals(0, not.getOutput().getValue());
    }

    @Test
    public void nandResults() {
        setInputs(0, 0);
        Assert.assertEquals(1, nand.getOutput().getValue());

        setInputs(0, 1);
        Assert.assertEquals(1, nand.getOutput().getValue());

        setInputs(1, 0);
        Assert.assertEquals(1, nand.getOutput().getValue());

        setInputs(1, 1);
        Assert.assertEquals(0, nand.getOutput().getValue());
    }

    @Test
    public void norResults() {
        setInputs(0, 0);
        Assert.assertEquals(1, nor.getOutput().getValue());

        setInputs(0, 1);
        Assert.assertEquals(0, nor.getOutput().getValue());

        setInputs(1, 0);
        Assert.assertEquals(0, nor.getOutput().getValue());

        setInputs(1, 1);
        Assert.assertEquals(0, nor.getOutput().getValue());
    }

    @Test
    public void xorResults() {
        setInputs(0, 0);
        Assert.assertEquals(0, xor.getOutput().getValue());

        setInputs(0, 1);
        Assert.assertEquals(1, xor.getOutput().getValue());

        setInputs(1, 0);
        Assert.assertEquals(1, xor.getOutput().getValue());

        setInputs(1, 1);
        Assert.assertEquals(0, xor.getOutput().getValue());
    }

    @Ignore
    private void setInputA(int _a) {
        a.setValue(_a);
    }

    @Ignore
    private void setInputs(int _a, int _b) {
        a.setValue(_a);
        b.setValue(_b);
    }
}
