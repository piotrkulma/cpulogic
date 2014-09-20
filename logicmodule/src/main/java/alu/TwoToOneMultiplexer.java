package alu;

import logic.LogicValue;
import logic.gate.ANDGate;
import logic.gate.NOTGate;
import logic.gate.ORGate;

/**
 * Created by Piotr Kulma on 14.09.14.
 */
public class TwoToOneMultiplexer {
    private LogicValue inputA;
    private LogicValue inputB;
    private LogicValue inputS;

    private LogicValue out;

    private NOTGate not;
    private ANDGate and1;
    private ANDGate and2;
    private ORGate or;

    public TwoToOneMultiplexer(LogicValue s, LogicValue a, LogicValue b) {
        this.inputA = a;
        this.inputB = b;
        this.inputS = s;

        initArchitecture();
        setOutput(this.inputS, this.inputA, this.inputB);
    }

    public LogicValue getOutput() {
        setOutput(this.inputS, this.inputA, this.inputB);
        return out;
    }

    public LogicValue getInputA() {
        return inputA;
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
        setOutput(this.inputS, this.inputA, this.inputB);
    }

    public LogicValue getInputB() {
        return inputB;
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
        setOutput(this.inputS, this.inputA, this.inputB);
    }

    public LogicValue getInputS() {
        return inputS;
    }

    public void setInputS(LogicValue inputS) {
        this.inputS = inputS;
        setOutput(this.inputS, this.inputA, this.inputB);
    }

    private void initArchitecture() {
        not = new NOTGate(inputS);
        and1 = new ANDGate(inputA, not.getOutput());
        and2 = new ANDGate(inputS, inputB);
        or = new ORGate(and1.getOutput(), and2.getOutput());
    }

    public void setOutput(LogicValue s, LogicValue a, LogicValue b) {
        not.setOutput(a, b);
        and1.setOutput(a, not.getOutput());
        and2.setOutput(s, b);

        out = or.getOutput();
    }
}
