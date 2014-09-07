package logic.gate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class XORGate extends LogicGate {
    public XORGate(int a, int b) {
        this.setInputA(a);
        this.setInputB(b);
    }

    @Override
    public int getOutput() {
        ORGate or = new ORGate(getInputA(), getInputB());
        NANDGate nand = new NANDGate(getInputA(), getInputB());
        ANDGate and = new ANDGate(or.getOutput(), nand.getOutput());

        return and.getOutput();
    }

    public int getInputA() {
        return inA;
    }

    public void setInputA(int inA) {
        this.inA = inA;
    }

    public int getInputB() {
        return inB;
    }

    public void setInputB(int inB) {
        this.inB = inB;
    }
}
