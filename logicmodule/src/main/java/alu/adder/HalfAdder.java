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

    private LogicValue output;
    private LogicValue carryOutput;

    private XORGate xor;
    private ANDGate and;

    public HalfAdder(LogicValue inputA, LogicValue inputB) {
        this.inputA = inputA;
        this.inputB = inputB;

        initArchitecture();
        setResults(this.inputA, this.inputB);
    }

    public LogicValue getInputA() {
        return inputA;
    }

    public void setInputA(LogicValue inputA) {
        this.inputA = inputA;
        setResults(inputA, inputB);
    }

    public LogicValue getInputB() {
        return inputB;
    }

    public void setInputB(LogicValue inputB) {
        this.inputB = inputB;
        setResults(this.inputA, this.inputB);
    }

    public LogicValue getOutput() {
        setResults(this.inputA, this.inputB);
        return output;
    }

    public LogicValue getCarryOutput() {
        setResults(this.inputA, this.inputB);
        return carryOutput;
    }

    public void setResults(LogicValue a, LogicValue b) {
        xor.setOutput(a, b);
        and.setOutput(a, b);

        output = xor.getOutput();
        carryOutput = and.getOutput();
    }

    private void initArchitecture() {
        xor = new XORGate(this.inputA, this.inputB);
        and = new ANDGate(this.inputA, this.inputB);
    }
}
