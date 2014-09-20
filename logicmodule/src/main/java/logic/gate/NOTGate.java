package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 07.09.14.
 */

public final class NOTGate extends LogicGate {
    public NOTGate(LogicValue a) {
        this.inA = a;
        this.inB = null;
        setOutput(this.inA, null);
    }

    public LogicValue getOutput() {
        setOutput(this.inA, null);
        return out;
    }

    public LogicValue getInput() {
        return inA;
    }

    public void setInput(LogicValue inA) {
        this.inA = inA;
    }

    public void setOutput(LogicValue a, LogicValue b) {
        if(a.getValue() == 1) {
            this.out.setValue(0);
        } else this.out.setValue(1);
    }
}
