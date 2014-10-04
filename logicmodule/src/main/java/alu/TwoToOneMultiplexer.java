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

    private NOTGate not;
    private ANDGate and1;
    private ANDGate and2;
    private ORGate or;

    public TwoToOneMultiplexer(LogicValue s, LogicValue a, LogicValue b) {
        this.inputA = a;
        this.inputB = b;
        this.inputS = s;

        initArchitecture();
    }

    public LogicValue getOutput() {
        return or.getOutput();
    }

    private void initArchitecture() {
        not = new NOTGate(inputS);
        and1 = new ANDGate(inputA, not.getOutput());
        and2 = new ANDGate(inputS, inputB);
        or = new ORGate(and1.getOutput(), and2.getOutput());
    }

    public void refresh(LogicValue s, LogicValue a, LogicValue b) {
        this.inputA = a;
        this.inputB = b;
        this.inputS = s;

        not.refresh(inputS, null);
        and1.refresh(inputA, not.getOutput());
        and2.refresh(inputS, inputB);
        or.refresh(and1.getOutput(), and2.getOutput());
    }
}
