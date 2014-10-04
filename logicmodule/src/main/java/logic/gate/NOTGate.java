package logic.gate;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 07.09.14.
 */

public final class NOTGate extends LogicGate {
    public NOTGate(LogicValue a) {
        this.inA = a;
        this.inB = null;
    }

    public LogicValue getOutput() {
        if(this.inA.getValue() == 1) {
            return new LogicValue(LogicValue.LOGIC_VALUE_ZERO_INT);
        } else return new LogicValue(LogicValue.LOGIC_VALUE_ONE_INT);
    }

    public void refresh(LogicValue a, LogicValue b) {
        this.inA.setValue(a.getValue());
    }
}
