package cpu.alu;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 04.10.14.
 */
public class EightBitAlu {
    public final static int BIT_COUNT = 8;

    private LogicValue[] inputA;
    private LogicValue[] inputB;
    private LogicValue[] operationCode;

    private OneBitAlu[] aluArray;

    public EightBitAlu(LogicValue[] operCode, LogicValue[] a, LogicValue[] b) {
        this.operationCode = operCode;
        this.inputA = a;
        this.inputB = b;
        initArchitecture();
    }

    public LogicValue[] getOutputValue() {
        LogicValue carryIn = new LogicValue(LogicValue.LOGIC_VALUE_ZERO_INT);
        LogicValue[] output = new LogicValue[BIT_COUNT];

        for(int i=0; i<BIT_COUNT; i++) {
            aluArray[i] = new OneBitAlu(operationCode, new LogicValue(carryIn.getValue()), inputA[i], inputB[i]);
            carryIn = aluArray[i].getCarryOutput();
            output[i] = new LogicValue(aluArray[i].getOperationOutput().getValue());
        }

        return output;
    }

    public LogicValue getCarryValue() {
        return aluArray[BIT_COUNT-1].getCarryOutput();
    }

    public void initArchitecture() {
        aluArray = new OneBitAlu[BIT_COUNT];

        refresh(operationCode, inputA, inputB);
    }

    public void refresh(LogicValue[] operCode, LogicValue[] a, LogicValue[] b) {
        this.operationCode = operCode;
        this.inputA = a;
        this.inputB = b;

        LogicValue carryIn = new LogicValue(LogicValue.LOGIC_VALUE_ZERO_INT);

        for(int i=0; i<BIT_COUNT; i++) {
            aluArray[i] = new OneBitAlu(operCode, carryIn, a[i], b[i]);
            carryIn = aluArray[i].getCarryOutput();
        }
    }
}
