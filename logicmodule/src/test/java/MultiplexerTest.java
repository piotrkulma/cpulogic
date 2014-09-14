import logic.Multiplexer;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 14.09.14.
 */
public class MultiplexerTest {
    private Multiplexer multiplexer = new Multiplexer(0, 0, 0);

    @Test
    public void multiplexerResult() {
        Assert.assertEquals(0, getMultiplexerOutput(0, 0, 0));
        Assert.assertEquals(0, getMultiplexerOutput(0, 0, 1));
        Assert.assertEquals(1, getMultiplexerOutput(0, 1, 0));
        Assert.assertEquals(1, getMultiplexerOutput(0, 1, 1));
        Assert.assertEquals(0, getMultiplexerOutput(1, 0, 0));
        Assert.assertEquals(1, getMultiplexerOutput(1, 0, 1));
        Assert.assertEquals(0, getMultiplexerOutput(1, 1, 0));
        Assert.assertEquals(1, getMultiplexerOutput(1, 1, 1));
    }

    @Ignore
    public int getMultiplexerOutput(int s, int a, int b) {
        multiplexer.setInputS(s);
        multiplexer.setInputA(a);
        multiplexer.setInputB(b);
        return multiplexer.getOutput();
    }
}
