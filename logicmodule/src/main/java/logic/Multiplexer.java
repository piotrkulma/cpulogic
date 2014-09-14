package logic;

import logic.gate.ANDGate;
import logic.gate.NOTGate;
import logic.gate.ORGate;

/**
 * Created by Piotr Kulma on 14.09.14.
 */
public class Multiplexer {
    private int inputA;
    private int inputB;
    private int inputS;

    public Multiplexer(int s, int a, int b) {
        this.inputA = a;
        this.inputB = b;
        this.inputS = s;
    }

    public int getOutput() {
        NOTGate not = new NOTGate(inputS);
        ANDGate and1 = new ANDGate(inputA, not.getOutput());
        ANDGate and2 = new ANDGate(inputS, inputB);
        ORGate or = new ORGate(and1.getOutput(), and2.getOutput());

        return or.getOutput();
    }

    public int getInputA() {
        return inputA;
    }

    public void setInputA(int inputA) {
        this.inputA = inputA;
    }

    public int getInputB() {
        return inputB;
    }

    public void setInputB(int inputB) {
        this.inputB = inputB;
    }

    public int getInputS() {
        return inputS;
    }

    public void setInputS(int inputS) {
        this.inputS = inputS;
    }
}
