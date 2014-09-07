package logic.gate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public class ANDGate extends LogicGate {

    public ANDGate(int a, int b) {
        this.setInputA(a);
        this.setInputB(b);
    }

    public int getOutput() {
        if(getInputA() == 1 && getInputB() == 1) {
            return 1;
        } else return 0;
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
