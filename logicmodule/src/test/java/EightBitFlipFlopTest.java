import cpu.programcounter.EightBitProgramCounter;
import logic.LogicValue;
import logic.utils.LogicValueUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 19.10.14.
 */
public class EightBitFlipFlopTest {
    @Test
    public void eightBitFlipFlopTest() {
        EightBitProgramCounter pc = new EightBitProgramCounter();
        int clock = 1;

        for(int i=0; i<256; i++) {
            pc.refresh(new LogicValue(1), new LogicValue(clock));
            String res = LogicValueUtil.getLogicValueArrayToString(pc.getOutput(), false);
            Assert.assertEquals(i, getIntValFromBinString(res));
            if(clock == 0) {
                clock = 1;
            } else {
                clock = 0;
            }
        }
    }

    @Ignore
    private static int getIntValFromBinString(String binString) {
        int ret = 0;

        for(int i=0; i<binString.length(); i++) {
            ret += ((binString.charAt(i) - 48) * Math.pow(2, i));
        }

        return ret;
    }
}
