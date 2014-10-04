import cpu.alu.OneBitAlu;
import logic.LogicValue;
import logic.utils.LogicValueUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Piotr Kulma on 04.10.14.
 */
public class OneBitAluTest {
    public static final String AND_OPERATION_CODE_STRING    = "000";
    public static final String OR_OPERATION_CODE_STRING     = "100";
    public static final String NOT_OPERATION_CODE_STRING    = "010";
    public static final String XOR_OPERATION_CODE_STRING    = "110";
    public static final String ADD_OPERATION_CODE_STRING    = "001";
    public static final String SUB_OPERATION_CODE_STRING    = "101";

    private LogicValue[] operationCode = LogicValueUtil.getLogicValueArrayFromString("000");
    private LogicValue carryInput = new LogicValue(0);
    private LogicValue inputA = new LogicValue(0);
    private LogicValue inputB = new LogicValue(0);

    private OneBitAlu oneBitAlu = new OneBitAlu(operationCode, carryInput, inputA, inputB);

    @Test
    public void oneBitAluANDOperationResults() {
        setValues(AND_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(AND_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(AND_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(AND_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());
    }

    @Test
    public void oneBitAluOROperationResults() {
        setValues(OR_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(OR_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(OR_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(OR_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());
    }

    @Test
    public void oneBitAluNOTOperationResults() {
        setValues(NOT_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(NOT_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(NOT_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(NOT_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());
    }

    @Test
    public void oneBitAluXOROperationResults() {
        setValues(XOR_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(XOR_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(XOR_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(XOR_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());
    }

    @Test
    public void oneBitAluADDOperationTest() {
        setValues(ADD_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 0, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 1, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 0, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());
    }

    @Test
    public void oneBitAluADDOperationCarryTest() {
        setValues(ADD_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 0, 1);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());

        setValues(ADD_OPERATION_CODE_STRING, 1, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());
    }

    @Test
    public void oneBitAluSUBOperationTest() {
        setValues(SUB_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 0, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 0, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 1, 0);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(0, oneBitAlu.getOperationOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getOperationOutput().getValue());
    }

    @Test
    public void oneBitAluSUBOperationBorrowTest() {
        setValues(SUB_OPERATION_CODE_STRING, 0, 0, 0);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 0, 0);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 0, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 1, 0);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 0, 0, 1);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 0, 1);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 0, 1, 1);
        Assert.assertEquals(0, oneBitAlu.getCarryOutput().getValue());

        setValues(SUB_OPERATION_CODE_STRING, 1, 1, 1);
        Assert.assertEquals(1, oneBitAlu.getCarryOutput().getValue());
    }

    @Ignore
    private void setValues(String opCodeString, int cIn, int a, int b) {
        LogicValueUtil.setLogicValueArrayFromString(opCodeString, operationCode);
        carryInput.setValue(cIn);
        inputA.setValue(a);
        inputB.setValue(b);

        oneBitAlu.refresh(operationCode, carryInput, inputA, inputB);
    }
}
