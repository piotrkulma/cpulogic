import cpu.alu.EightBitAlu;
import logic.LogicValue;
import logic.utils.LogicValueUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 04.10.14.
 */

public class EightBitAluTest {
    private LogicValue[] a = LogicValueUtil.getLogicValueArrayFromString("00000000");
    private LogicValue[] b = LogicValueUtil.getLogicValueArrayFromString("00000000");
    private LogicValue[] operCode = LogicValueUtil.getLogicValueArrayFromString("000");

    private EightBitAlu eightBitAlu = null;

    @Test
    public void eightBitAluORTest() {
        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "10101010", "01010101");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "11110000", "00001111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "11111111", "00000000");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "00000000", "11111111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "00000000", "00000000");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "11110000", "00000000");
        Assert.assertEquals("11110000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "10101010", "00000000");
        Assert.assertEquals("10101010", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "00000000", "01010101");
        Assert.assertEquals("01010101", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "11111111", "11111111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.OR_OPERATION_CODE_STRING, "10101010", "10101010");
        Assert.assertEquals("10101010", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));
    }

    @Test
    public void eightBitAluANDTest() {
        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "11111111", "11111111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "10101010", "10101010");
        Assert.assertEquals("10101010", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "11111111", "00000000");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "00000000", "11111111");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "00000000", "00000000");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "11110000", "00000000");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "10101010", "00000000");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "00000000", "01010101");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "10101010", "01010101");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "11110000", "11110000");
        Assert.assertEquals("11110000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "00001111", "00001111");
        Assert.assertEquals("00001111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.AND_OPERATION_CODE_STRING, "01010101", "01010101");
        Assert.assertEquals("01010101", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));
    }

    @Test
    public void eightBitAluNOTTest() {
        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "11111111", "00000000");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "00000000", "00000000");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "10101010", "00000000");
        Assert.assertEquals("01010101", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "11110000", "00000000");
        Assert.assertEquals("00001111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "00001111", "00000000");
        Assert.assertEquals("11110000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "11111111", "11111111");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "00000000", "11111111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "10101010", "11111111");
        Assert.assertEquals("01010101", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "11110000", "11111111");
        Assert.assertEquals("00001111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.NOT_OPERATION_CODE_STRING, "00001111", "11111111");
        Assert.assertEquals("11110000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));
    }

    @Test
    public void eightBitAluXORTest() {
        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "11111111", "00000000");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "00000000", "11111111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "11111111", "11111111");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "10101010", "01010101");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "10101010", "10101010");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "01010101", "01010101");
        Assert.assertEquals("00000000", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "11110000", "00001111");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));

        setValues(OneBitAluTest.XOR_OPERATION_CODE_STRING, "00001111", "11110000");
        Assert.assertEquals("11111111", LogicValueUtil.getLogicValueArrayToString(eightBitAlu.getOutputValue()));
    }

    @Ignore
    public void setValues(String opCodeStr, String a, String b) {
        LogicValueUtil.setLogicValueArrayFromString(opCodeStr, operCode);
        LogicValueUtil.setLogicValueArrayFromString(a, this.a);
        LogicValueUtil.setLogicValueArrayFromString(b, this.b);

        if(eightBitAlu == null) {
            eightBitAlu = new EightBitAlu(operCode, this.a, this.b);
        }

        eightBitAlu.refresh(operCode, this.a, this.b);
    }
}
