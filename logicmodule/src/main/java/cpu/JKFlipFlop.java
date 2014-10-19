package cpu;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 19.10.14.
 *
 * Przerzutnik JK umożliwiający skonstruowanie licznika
 * rozkazów PC
 */

public class JKFlipFlop {
    private LogicValue jInput;
    private LogicValue kInput;
    private LogicValue clockInput;

    private LogicValue qOutput;
    private LogicValue qPrimeOutput;

    public JKFlipFlop(LogicValue j, LogicValue k, LogicValue clock) {
        this.jInput = j;
        this.kInput = k;
        this.clockInput = clock;

        initArchitecture();
        refresh(j, k, clock);
    }

    public void refresh(LogicValue j, LogicValue k, LogicValue clock) {
        this.jInput.setValue(j.getValue());
        this.kInput.setValue(k.getValue());

        nothing();
        reset();
        set();
        toggle(clock);

        this.clockInput.setValue(clock.getValue());
    }

    public LogicValue getQOutput() {
        return this.qOutput;
    }

    public LogicValue getQPrimeOutput() {
        return this.qPrimeOutput;
    }

    private boolean nothing() {
        if(jInput.isEqualTo(LogicValue.LOGIC_VALUE_ZERO) && kInput.isEqualTo(LogicValue.LOGIC_VALUE_ZERO)) {
            return true;
        }

        return false;
    }

    private boolean reset() {
        if(jInput.isEqualTo(LogicValue.LOGIC_VALUE_ZERO) && kInput.isEqualTo(LogicValue.LOGIC_VALUE_ONE)) {
            qOutput = new LogicValue(0);
            qPrimeOutput = new LogicValue(1);
            return true;
        }

        return false;
    }

    private boolean set() {
        if(jInput.isEqualTo(LogicValue.LOGIC_VALUE_ONE) && kInput.isEqualTo(LogicValue.LOGIC_VALUE_ZERO)) {
            qOutput = new LogicValue(1);
            qPrimeOutput = new LogicValue(0);
            return true;
        }

        return false;
    }

    private boolean toggle(LogicValue clockNewState) {
        if(jInput.isEqualTo(LogicValue.LOGIC_VALUE_ONE) &&
                kInput.isEqualTo(LogicValue.LOGIC_VALUE_ONE) &&
                clockNewState.getValue() != clockInput.getValue()) {
            if(qOutput.isEqualTo(LogicValue.LOGIC_VALUE_ONE)) {
                qOutput = new LogicValue(0);
                qPrimeOutput = new LogicValue(1);
            } else {
                qOutput = new LogicValue(1);
                qPrimeOutput = new LogicValue(0);
            }

            return true;
        }

        return false;
    }

    private void initArchitecture() {
        this.jInput = new LogicValue(0);
        this.kInput = new LogicValue(1);
        this.clockInput = new LogicValue(1);

        this.qOutput = new LogicValue(0);
        this.qPrimeOutput = new LogicValue(1);
    }
}
