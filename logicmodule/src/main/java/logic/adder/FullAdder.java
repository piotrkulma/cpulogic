package logic.adder;

import logic.gate.ORGate;

/**
 * Created by PiotrKulma on 07.09.14.
 */
public class FullAdder {
    private int inputA;
    private int inputB;

    private int output;
    private int carryInput;
    private int carryOutput;

    public FullAdder(int carryInput, int inputA, int inputB) {
        this.carryInput = carryInput;
        this.inputA = inputA;
        this.inputB = inputB;
        setResults(carryInput, inputA, inputB);
    }

    public int getInputA() {
        return inputA;
    }

    public void setInputA(int inputA) {
        this.inputA = inputA;
        setResults(carryInput, inputA, inputB);
    }

    public int getInputB() {
        return inputB;
    }

    public void setInputB(int inputB) {
        this.inputB = inputB;
        setResults(carryInput, inputA, inputB);
    }

    public int getCarryInput() {
        return carryInput;
    }

    public void setCarryInput(int carryInput) {
        this.carryInput = carryInput;
        setResults(carryInput, inputA, inputB);
    }

    public int getCarryOutput() {
        return carryOutput;
    }

    public int getOutput() {
        return output;
    }

    private void setResults(int cin, int a, int b) {
        HalfAdder ha1 = new HalfAdder(a, b);
        HalfAdder ha2 = new HalfAdder(cin, ha1.getOutput());
        ORGate or = new ORGate(ha2.getCarryOutput(), ha1.getCarryOutput());

        output = ha2.getOutput();
        carryOutput = or.getOutput();
    }
}
