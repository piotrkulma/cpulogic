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
        setResults(this.inputA, this.inputB);
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
        setResults(this.inputA, this.inputB);
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
        setResults(this.inputA, this.inputB);
    }

    public LogicValue getOutput() {
        setResults(this.inputA, this.inputB);
        return output;
    }

    public LogicValue getBorrowOutput() {
        setResults(this.inputA, this.inputB);
        return borrowOutput;
    }

    public void setResults(LogicValue a, LogicValue b) {
        xor.setOutput(a, b);
        not.setOutput(b, null);

        output = xor.getOutput();
        borrowOutput = and.getOutput();
    }

    private void initArchitecture() {
        xor = new XORGate(this.inputA, this.inputB);
        not = new NOTGate(this.inputB);
        and = new ANDGate(this.inputA, not.getOutput());
    }
}
