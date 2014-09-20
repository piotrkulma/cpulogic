package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma Kulma on 07.09.14.
 */
public abstract class LogicGate {
    protected LogicValue inA;
    protected LogicValue inB;
    protected LogicValue out;

    public LogicGate() {
        this.inA = new LogicValue();
        this.inB = new LogicValue();

        out = new LogicValue(0);
    }

    public LogicGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;

        out = new LogicValue(0);
    }

    public abstract LogicValue getOutput();
    public abstract void setOutput(LogicValue a, LogicValue b);

    @Override
    public String toString() {
        return
                this.getClass().getName()+ " [" +
                        "inA: " + ((inA == null)? "null" : inA.getValue()) + ", "+
                        "inB: " + ((inB == null)? "null" : inB.getValue()) + ", "+
                        "out: " + ((getOutput() == null)? "null" : getOutput().getValue()) +
                        "]";
    }
}
