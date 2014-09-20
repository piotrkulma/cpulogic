package alu.adder;

import logic.LogicValue;
import logic.gate.ORGate;

/**
 * Created by PiotrKulma on 07.09.14.
 */
public class FullAdder {
    private LogicValue inputA;
    private LogicValue inputB;

    private LogicValue output;
    private LogicValue carryInput;
    private LogicValue carryOutput;

    private HalfAdder ha1;
    private HalfAdder ha2;
    private ORGate or;

    public FullAdder(LogicValue carryInput, LogicValue inputA, LogicValue inputB) {
        this.carryInput = carryInput;
        this.inputA = inputA;
        this.inputB = inputB;

        initArchitecture();
        setResults(this.carryInput, this.inputA, this.inputB);
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
        setResults(this.carryInput, this.inputA, this.inputB);
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
        setResults(this.carryInput, this.inputA, this.inputB);
    }

    public LogicValue getCarryOutput() {
        setResults(this.carryInput, this.inputA, this.inputB);
        return carryOutput;
    }

    public LogicValue getOutput() {
        setResults(this.carryInput, this.inputA, this.inputB);
        return output;
    }

    public void setResults(LogicValue cin, LogicValue a, LogicValue b) {
        ha1.setResults(a, b);
        ha2.setResults(cin, ha1.getOutput());

        output = ha2.getOutput();
        carryOutput = or.getOutput();
    }

    private void initArchitecture() {
        ha1 = new HalfAdder(this.inputA, this.inputB);
        ha2 = new HalfAdder(this.carryInput, ha1.getOutput());
        or = new ORGate(ha2.getCarryOutput(), ha1.getCarryOutput());
    }
}
