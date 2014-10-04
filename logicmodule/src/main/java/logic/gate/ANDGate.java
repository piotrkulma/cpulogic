package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 07.09.14.
 */
public final class ANDGate extends LogicGate {

    public ANDGate(LogicValue a, LogicValue b) {
        this.inA = a;
        this.inB = b;
    }

    public LogicValue getOutput() {
        if(this.inA.getValue() == 1 &&  this.inB.getValue() == 1) {
            return new LogicValue(LogicValue.LOGIC_VALUE_ONE_INT);
        } return new LogicValue(LogicValue.LOGIC_VALUE_ZERO_INT);
    }

    public void refresh(LogicValue a, LogicValue b) {
        this.inA.setValue(a.getValue());
        this.inB.setValue(b.getValue());
    }
}
