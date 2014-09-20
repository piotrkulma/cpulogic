package alu.subtractor;

import logic.LogicValue;
import logic.gate.ORGate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class FullSubtractor {
    private LogicValue inputA;
    private LogicValue inputB;

    private LogicValue output;
    private LogicValue borrowInput;
    private LogicValue borrowOutput;

    private HalfSubtractor fs1;
    private HalfSubtractor fs2;
    private ORGate or;

    public FullSubtractor(LogicValue borrowInput, LogicValue inputA, LogicValue inputB) {
        this.borrowInput = borrowInput;
        this.inputA = inputA;
        this.inputB = inputB;

        setArchitecture();
        setResults(this.borrowInput, this.inputA, this.inputB);
    }

    public LogicValue getInputA() {
        return inputA;
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
        setResults(this.borrowInput, this.inputA, this.inputB);
    }

    public LogicValue getInputB() {
        return inputB;
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
        setResults(this.borrowInput, this.inputA, this.inputB);
    }

    public LogicValue getBorrowInput() {
        return borrowInput;
    }

    public void setBorrowInput(LogicValue borrowInput) {
        this.borrowInput = borrowInput;
        setResults(this.borrowInput, this.inputA, this.inputB);
    }

    public LogicValue getBorrowOutput() {
        setResults(this.borrowInput, this.inputA, this.inputB);
        return borrowOutput;
    }

    public LogicValue getOutput() {
        setResults(this.borrowInput, this.inputA, this.inputB);
        return output;
    }

    private void setResults(LogicValue bin, LogicValue a, LogicValue b) {
        fs1.setResults(a, b);
        fs2.setResults(bin, fs1.getOutput());

        output = fs2.getOutput();
        borrowOutput = or.getOutput();
    }

    private void setArchitecture() {
        fs1 = new HalfSubtractor(this.inputA, this.inputB);
        fs2 = new HalfSubtractor(this.borrowInput, fs1.getOutput());
        or = new ORGate(fs2.getBorrowOutput(), fs1.getBorrowOutput());
    }
}
