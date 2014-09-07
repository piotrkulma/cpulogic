package logic.adder;

import logic.gate.ANDGate;
import logic.gate.XORGate;

/**
 * Created by PiotrKulma on 07.09.14.
 */
public class HalfAdder {
    private int inputA;
    private int inputB;

    private int output;
    private int carryOutput;

    public HalfAdder(int inputA, int inputB) {
        this.inputA = inputA;
        this.inputB = inputB;
        setResults(inputA, inputB);
    }

    public int getInputA() {
        return inputA;
    }

    public void setInputA(int inputA) {
        this.inputA = inputA;
        setResults(inputA, inputB);
    }

    public int getInputB() {
        return inputB;
    }

    public void setInputB(int inputB) {
        this.inputB = inputB;
        setResults(inputA, inputB);
    }

    public int getOutput() {
        return output;
    }

    public int getCarryOutput() {
        return carryOutput;
    }

    private void setResults(int a, int b) {
        XORGate xor = new XORGate(a, b);
        ANDGate and = new ANDGate(a, b);

        output = xor.getOutput();
        carryOutput = and.getOutput();
    }
}
