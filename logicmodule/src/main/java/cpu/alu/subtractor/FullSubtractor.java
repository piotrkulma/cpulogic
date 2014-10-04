package cpu.alu.subtractor;

import logic.LogicValue;
import logic.gate.ORGate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class FullSubtractor {
    private LogicValue inputA;
    private LogicValue inputB;

    private LogicValue borrowInput;

    private HalfSubtractor fs1;
    private HalfSubtractor fs2;
    private ORGate or;

    public FullSubtractor(LogicValue borrowInput, LogicValue inputA, LogicValue inputB) {
        this.borrowInput = borrowInput;
        this.inputA = inputA;
        this.inputB = inputB;

        setArchitecture();
    }

    public LogicValue getBorrowOutput() {
        return or.getOutput();
    }

    public LogicValue getOutput() {
        return fs2.getOutput();
    }

    public void refresh(LogicValue bin, LogicValue a, LogicValue b) {
        this.borrowInput = bin;
        this.inputA = a;
        this.inputB = b;

        fs1.refresh(inputA, inputB);
        fs2.refresh(borrowInput, fs1.getOutput());
        or.refresh(fs2.getBorrowOutput(), fs1.getBorrowOutput());
    }

    private void setArchitecture() {
        fs1 = new HalfSubtractor(this.inputA, this.inputB);
        fs2 = new HalfSubtractor(this.borrowInput, fs1.getOutput());
        or = new ORGate(fs2.getBorrowOutput(), fs1.getBorrowOutput());
    }
}
