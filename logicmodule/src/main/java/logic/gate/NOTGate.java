package logic.gate;

/**
 * Created by Piotr Kulma on 07.09.14.
 */

public class NOTGate extends LogicGate {
    public NOTGate(int a) {
        this.setInput(a);
    }

    public int getOutput() {
        if(getInput() == 1) {
            return 0;
        } else return 1;
    }

    public int getInput() {
        return inA;
    }

    public void setInput(int inA) {
        this.inA = inA;
    }
}
