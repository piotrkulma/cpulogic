import alu.subtractor.FullSubtractor;
import alu.subtractor.HalfSubtractor;
import logic.LogicValue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 20.09.14.
 */
public class FullSubtractorTest {
    private LogicValue a = new LogicValue(0);
    private LogicValue b = new LogicValue(0);
    private LogicValue bin = new LogicValue(0);

    private FullSubtractor fa = new FullSubtractor(bin, a, b);

    @Test
    public void fullSubtractorTest() {
        setLogicValues(0, 0, 0);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(0, 0, 1);
        Assert.assertEquals(1, fa.getOutput().getValue());

        setLogicValues(0, 1, 0);
        Assert.assertEquals(1, fa.getOutput().getValue());

        setLogicValues(0, 1, 1);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(1, 0, 0);
        Assert.assertEquals(1, fa.getOutput().getValue());

        setLogicValues(1, 0, 1);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(1, 1, 0);
        Assert.assertEquals(0, fa.getOutput().getValue());

        setLogicValues(1, 1, 1);
        Assert.assertEquals(1, fa.getOutput().getValue());
    }

    @Test
    public void fullSubtractorBorrowTest() {
        setLogicValues(0, 0, 0);
        Assert.assertEquals(0, fa.getBorrowOutput().getValue());

        setLogicValues(0, 0, 1);
        Assert.assertEquals(1, fa.getBorrowOutput().getValue());

        setLogicValues(0, 1, 0);
        Assert.assertEquals(1, fa.getBorrowOutput().getValue());

        setLogicValues(0, 1, 1);
        Assert.assertEquals(1, fa.getBorrowOutput().getValue());

        setLogicValues(1, 0, 0);
        Assert.assertEquals(0, fa.getBorrowOutput().getValue());

        setLogicValues(1, 0, 1);
        Assert.assertEquals(0, fa.getBorrowOutput().getValue());

        setLogicValues(1, 1, 0);
        Assert.assertEquals(0, fa.getBorrowOutput().getValue());

        setLogicValues(1, 1, 1);
        Assert.assertEquals(1, fa.getBorrowOutput().getValue());
    }

    @Ignore
    public void setLogicValues(int _b, int _a, int _bin) {
        a.setValue(_a);
        b.setValue(_b);
        bin.setValue(_bin);
        fa.refresh(bin, a, b);
    }
}
