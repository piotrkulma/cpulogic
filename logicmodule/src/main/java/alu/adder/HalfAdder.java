package alu.adder;

import logic.LogicValue;
import logic.gate.ANDGate;
import logic.gate.XORGate;

/**
 * Created by PiotrKulma on 07.09.14.
 */
public class HalfAdder {
    private LogicValue inputA;
    private LogicValue inputB;

    private XORGate xor;
    private ANDGate and;

    public HalfAdder(LogicValue inputA, LogicValue inputB) {
        this.inputA = inputA;
        this.inputB = inputB;

        initArchitecture();
    }

    public LogicValue getOutput() {
        return xor.getOutput();
    }

    public LogicValue getCarryOutput() {
        return and.getOutput();
    }

    public void refresh(LogicValue a, LogicValue b) {
        this.inputA = a;
        this.inputB = b;

        xor.refresh(inputA, inputB);
        and.refresh(inputA, inputB);
    }

    private void initArchitecture() {
        xor = new XORGate(this.inputA, this.inputB);
        and = new ANDGate(this.inputA, this.inputB);
    }
}
