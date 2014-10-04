import alu.TwoToOneMultiplexer;
import logic.LogicValue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 14.09.14.
 */
public class MultiplexerTest {
    private LogicValue s = new LogicValue(0);
    private LogicValue a = new LogicValue(0);
    private LogicValue b = new LogicValue(0);

    private TwoToOneMultiplexer multiplexer = new TwoToOneMultiplexer(s, a, b);

    @Test
    public void multiplexerResult() {
        setLogicValues(0, 0, 0);
        Assert.assertEquals(0, multiplexer.getOutput().getValue());

        setLogicValues(0, 0, 1);
        Assert.assertEquals(0, multiplexer.getOutput().getValue());

        setLogicValues(0, 1, 0);
        Assert.assertEquals(1, multiplexer.getOutput().getValue());

        setLogicValues(0, 1, 1);
        Assert.assertEquals(1, multiplexer.getOutput().getValue());

        setLogicValues(1, 0, 0);
        Assert.assertEquals(0, multiplexer.getOutput().getValue());

        setLogicValues(1, 0, 1);
        Assert.assertEquals(1, multiplexer.getOutput().getValue());

        setLogicValues(1, 1, 0);
        Assert.assertEquals(0, multiplexer.getOutput().getValue());

        setLogicValues(1, 1, 1);
        Assert.assertEquals(1, multiplexer.getOutput().getValue());
    }

    @Ignore
    public void setLogicValues(int _s, int _a, int _b) {
        s.setValue(_s);
        a.setValue(_a);
        b.setValue(_b);
        multiplexer.refresh(s, a, b);
    }
}
