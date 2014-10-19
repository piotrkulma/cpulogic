package memory;

import logic.LogicValue;
import logic.utils.LogicValueUtil;
import memory.Memory;

/**
 * Created by Piotr Kulma on 04.10.14.
 */
public class EightBitRegister implements Memory {
    public LogicValue[] input;
    public LogicValue[] memory;
    public LogicValue[] output;

    public EightBitRegister() {
        this.input = LogicValueUtil.getLogicValueArrayFromString("00000000");
        this.memory = LogicValueUtil.getLogicValueArrayFromString("00000000");
        this.output = LogicValueUtil.getLogicValueArrayFromString("00000000");
    }

    public void enable() {
        copyLogicValueArray(memory, output);
    }

    public void set() {
        copyLogicValueArray(input, memory);
    }

    private void copyLogicValueArray(LogicValue[] source, LogicValue[] dest) {
        for(int i=0; i<source.length; i++) {
            dest[i].setValue(source[i].getValue());
        }
    }
}
