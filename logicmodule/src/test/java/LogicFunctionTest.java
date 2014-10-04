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
        setInputs(and, 0, 0);
        Assert.assertEquals(0, and.getOutput().getValue());

        setInputs(and, 0, 1);
        Assert.assertEquals(0, and.getOutput().getValue());

        setInputs(and, 1, 0);
        Assert.assertEquals(0, and.getOutput().getValue());

        setInputs(and, 1, 1);
        Assert.assertEquals(1, and.getOutput().getValue());
    }

    @Test
    public void orResults() {
        setInputs(or, 0, 0);
        Assert.assertEquals(0, or.getOutput().getValue());

        setInputs(or, 0, 1);
        Assert.assertEquals(1, or.getOutput().getValue());

        setInputs(or, 1, 0);
        Assert.assertEquals(1, or.getOutput().getValue());

        setInputs(or, 1, 1);
        Assert.assertEquals(1, or.getOutput().getValue());
    }

    @Test
    public void notResults() {
        setInputs(not, 0, 0);
        Assert.assertEquals(1, not.getOutput().getValue());

        setInputs(not, 1, 0);
        Assert.assertEquals(0, not.getOutput().getValue());
    }

    @Test
    public void nandResults() {
        setInputs(nand, 0, 0);
        Assert.assertEquals(1, nand.getOutput().getValue());

        setInputs(nand, 0, 1);
        Assert.assertEquals(1, nand.getOutput().getValue());

        setInputs(nand, 1, 0);
        Assert.assertEquals(1, nand.getOutput().getValue());

        setInputs(nand, 1, 1);
        Assert.assertEquals(0, nand.getOutput().getValue());
    }

    @Test
    public void norResults() {
        setInputs(nor, 0, 0);
        Assert.assertEquals(1, nor.getOutput().getValue());

        setInputs(nor, 0, 1);
        Assert.assertEquals(0, nor.getOutput().getValue());

        setInputs(nor, 1, 0);
        Assert.assertEquals(0, nor.getOutput().getValue());

        setInputs(nor, 1, 1);
        Assert.assertEquals(0, nor.getOutput().getValue());
    }

    @Test
    public void xorResults() {
        setInputs(xor, 0, 0);
        Assert.assertEquals(0, xor.getOutput().getValue());

        setInputs(xor, 0, 1);
        Assert.assertEquals(1, xor.getOutput().getValue());

        setInputs(xor, 1, 0);
        Assert.assertEquals(1, xor.getOutput().getValue());

        setInputs(xor, 1, 1);
        Assert.assertEquals(0, xor.getOutput().getValue());
    }

    @Ignore
    private void setInputA(int _a) {
        a.setValue(_a);
    }

    @Ignore
    private void setInputs(LogicGate gate, int _a, int _b) {
        gate.refresh(new LogicValue(_a), new LogicValue(_b));
    }
}
