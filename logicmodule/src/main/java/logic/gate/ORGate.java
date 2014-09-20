package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public final class ORGate extends LogicGate {

    public ORGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;
        setOutput(this.inA, this.inB);
    }

    public LogicValue getOutput() {
        setOutput(this.inA, this.inB);

        return out;
    }

    public LogicValue getInputA() {
        return inA;
    }

    public void setInputA(LogicValue inA) {
        this.inA = inA;
        setOutput(this.inA, this.inB);
    }

    public LogicValue getInputB() {
        return inB;
    }

    public void setInputB(LogicValue inB) {
        this.inB = inB;
        setOutput(this.inA, this.inB);
    }

    public void setOutput(LogicValue a, LogicValue b) {
        if(a.getValue() == 1 || b.getValue() == 1) {
            this.out.setValue(1);
        } else this.out.setValue(0);
    }
}