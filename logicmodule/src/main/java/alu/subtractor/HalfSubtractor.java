package alu.subtractor;

import logic.LogicValue;
import logic.gate.ANDGate;
import logic.gate.NOTGate;
import logic.gate.XORGate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class HalfSubtractor {
    private LogicValue inputA;
    private LogicValue inputB;

    private LogicValue output;
    private LogicValue borrowOutput;

    private XORGate xor;
    private NOTGate not;
    private ANDGate and;

    public HalfSubtractor(LogicValue inputA, LogicValue inputB) {
        this.inputA = inputA;
        this.inputB = inputB;

        initArchitecture();
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
    }

    public LogicValue getOutput() {
        return output = xor.getOutput();
    }

    public LogicValue getBorrowOutput() {
        return borrowOutput = and.getOutput();
    }

    public void refresh(LogicValue a, LogicValue b) {
        xor.refresh(a, b);
        not.refresh(b, null);
        and.refresh(this.inputA, not.getOutput());
    }

    private void initArchitecture() {
        xor = new XORGate(this.inputA, this.inputB);
        not = new NOTGate(this.inputB);
        and = new ANDGate(this.inputA, not.getOutput());
    }
}
