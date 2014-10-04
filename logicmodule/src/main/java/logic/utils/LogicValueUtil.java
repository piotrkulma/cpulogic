package logic.utils;

import logic.LogicValue;

/**
 * Created by Piotr Kulma on 04.10.14.
 */
public class LogicValueUtil {
    public static void setLogicValueArrayFromString(String code, LogicValue[] logicValueArray) {
        for(int i=0; i<code.length(); i++) {
            logicValueArray[i].setValue(getIntFromCharacter(code.charAt(i)));
        }
    }

    public static LogicValue[] getLogicValueArrayFromString(String code) {
        LogicValue[] logicValueArray = new LogicValue[code.length()];

        for(int i=0; i<code.length(); i++) {
            logicValueArray[i]= new LogicValue(getIntFromCharacter(code.charAt(i)));
        }

        return logicValueArray;
    }

    public static String getLogicValueArrayToString(LogicValue[] logicValueArray) {
        String output = "";
        for(LogicValue lv : logicValueArray) {
            output = output + Integer.toString(lv.getValue());
        }

        return output;
    }

    public static int getIntFromCharacter(char c) {
        return (c-48);
    }
}
