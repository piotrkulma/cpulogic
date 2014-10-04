package alu.adder;

import logic.LogicValue;
import logic.gate.ORGate;

/**
 * Created by PiotrKulma on 07.09.14.
 */
public class FullAdder {
    private LogicValue inputA;
    private LogicValue inputB;

    private LogicValue carryInput;

    private HalfAdder ha1;
    private HalfAdder ha2;
    private ORGate or;

    public FullAdder(LogicValue carryInput, LogicValue inputA, LogicValue inputB) {
        this.carryInput = carryInput;
        this.inputA = inputA;
        this.inputB = inputB;

        initArchitecture();
    }

    public LogicValue getCarryOutput() {
        return or.getOutput();
    }

    public LogicValue getOutput() {
        return ha2.getOutput();
    }

    public void refresh(LogicValue cin, LogicValue a, LogicValue b) {
        this.carryInput = cin;
        this.inputA = a;
        this.inputB = b;

        ha1.refresh(inputA, inputB);
        ha2.refresh(carryInput, ha1.getOutput());
        or.refresh(ha2.getCarryOutput(), ha1.getCarryOutput());
    }

    private void initArchitecture() {
        ha1 = new HalfAdder(this.inputA, this.inputB);
        ha2 = new HalfAdder(this.carryInput, ha1.getOutput());
        or = new ORGate(ha2.getCarryOutput(), ha1.getCarryOutput());
    }
}
