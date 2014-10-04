package logic;

/**
 * Created by Piotr Kulma on 20.09.14.
 */
public class LogicValue {
    public static final int LOGIC_VALUE_ZERO_INT        = 0;
    public static final int LOGIC_VALUE_ONE_INT         = 1;

    public static final LogicValue LOGIC_VALUE_ZERO     = new LogicValue(LOGIC_VALUE_ZERO_INT);
    public static final LogicValue LOGIC_VALUE_ONE      = new LogicValue(LOGIC_VALUE_ONE_INT);

    private int value;

    public LogicValue() {
        setValue(LOGIC_VALUE_ZERO_INT);
    }

    public LogicValue(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value == LOGIC_VALUE_ZERO_INT || value == LOGIC_VALUE_ONE_INT) {
            this.value = value;
        } else {
            throw new RuntimeException("Logic value is " + value + " expected value 0 or 1 ");
        }
    }

    public boolean isEqualTo(LogicValue logicValue) {
        if(this.getValue() == logicValue.getValue()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [value: " + value + "]";
    }
}
