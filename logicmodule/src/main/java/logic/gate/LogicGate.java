package logic.gate;

/**
 * Created by Piotr Kulma Kulma on 07.09.14.
 */
public abstract class LogicGate {
    protected int inA;
    protected int inB;

    public LogicGate() {
        this.inA = 0;
        this.inB = 0;
    }

    public abstract int getOutput();
}
