package logic;

/**
 * Created by Piotr Kulma on 20.09.14.
 */
public class LogicValue {
    public static int LOGIC_VALUE_ZERO      = 0;
    public static int LOGIC_VALUE_ONE       = 1;

    private int value;

    public LogicValue() {
        setValue(LOGIC_VALUE_ZERO);
    }

    public LogicValue(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value == LOGIC_VALUE_ZERO || value == LOGIC_VALUE_ONE ) {
            this.value = value;
        } else {
            throw new RuntimeException("Logic value is " + value + " expected value 0 or 1 ");
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [value: " + value + "]";
    }
}
