package logic.subtractor;

import logic.gate.ANDGate;
import logic.gate.NOTGate;
import logic.gate.XORGate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class HalfSubtractor {
    private int inputA;
    private int inputB;

    private int output;
    private int carryOutput;

    public HalfSubtractor(int inputA, int inputB) {
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
        NOTGate not = new NOTGate(b);
        ANDGate and = new ANDGate(a, not.getOutput());

        output = xor.getOutput();
        carryOutput = and.getOutput();
    }
}
