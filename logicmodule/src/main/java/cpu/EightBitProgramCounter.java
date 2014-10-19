package cpu;

import logic.LogicValue;
import logic.gate.ANDGate;

/**
 * Created by Piotr Kulma on 19.10.14.
 */
public class EightBitProgramCounter {
    public final static int BIT_COUNT = 8;

    private ANDGate[] and;
    private JKFlipFlop[] flipFlop;
    private LogicValue clockEnable;

    public EightBitProgramCounter() {
        initArchitecture();
    }

    public LogicValue[] getOutput() {
        LogicValue[] output = new LogicValue[BIT_COUNT];
        for(int i=0; i<BIT_COUNT; i++) {
            output[i] = new LogicValue(flipFlop[i].getQPrimeOutput().getValue());
        }

        return output;
    }

    public void refresh(LogicValue clockEnable, LogicValue clock) {
        for(int i=0; i<BIT_COUNT; i++) {
            if(i > 0) {
                and[i].refresh(clockEnable, flipFlop[i - 1].getQOutput());
                flipFlop[i].refresh(and[i].getOutput(), and[i].getOutput(), flipFlop[i - 1].getQOutput());
            } else {
                flipFlop[i].refresh(clockEnable, clockEnable, clock);
            }
        }
    }

    private void initArchitecture() {
        this.clockEnable = new LogicValue(0);

        and = new ANDGate[BIT_COUNT];
        flipFlop = new JKFlipFlop[BIT_COUNT];

        LogicValue clock = new LogicValue(0);
        for(int i=0; i<BIT_COUNT; i++) {
            if(i > 0) {
                and[i] = new ANDGate(clockEnable, flipFlop[i - 1].getQOutput());
                flipFlop[i] = new JKFlipFlop(and[i].getOutput(), and[i].getOutput(), clock);
            } else {
                flipFlop[i] = new JKFlipFlop(clockEnable, clockEnable, clock);
            }
        }
    }
}
