package logic.subtractor;

import logic.gate.ORGate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class FullSubtractor {
    private int inputA;
    private int inputB;

    private int output;
    private int borrowInput;
    private int borrowOutput;

    public FullSubtractor(int borrowInput, int inputA, int inputB) {
        this.borrowInput = borrowInput;
        this.inputA = inputA;
        this.inputB = inputB;
        setResults(borrowInput, inputA, inputB);
    }

    public int getInputA() {
        return inputA;
    }

    public void setInputA(int inputA) {
        this.inputA = inputA;
        setResults(borrowInput, inputA, inputB);
    }

    public int getInputB() {
        return inputB;
    }

    public void setInputB(int inputB) {
        this.inputB = inputB;
        setResults(borrowInput, inputA, inputB);
    }

    public int getBorrowInput() {
        return borrowInput;
    }

    public void setBorrowInput(int borrowInput) {
        this.borrowInput = borrowInput;
        setResults(borrowInput, inputA, inputB);
    }

    public int getBorrowOutput() {
        return borrowOutput;
    }

    public int getOutput() {
        return output;
    }

    private void setResults(int bin, int a, int b) {
        HalfSubtractor fs1 = new HalfSubtractor(a, b);
        HalfSubtractor fs2 = new HalfSubtractor(bin, fs1.getOutput());
        ORGate or = new ORGate(fs2.getBorrowOutput(), fs1.getBorrowOutput());

        output = fs2.getOutput();
        borrowOutput = or.getOutput();
    }
}
