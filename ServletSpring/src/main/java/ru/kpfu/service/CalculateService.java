package ru.kpfu.service;

import org.springframework.stereotype.Component;

/**
 * Created by Anatoly on 05.03.2017.
 */
@Component
public class CalculateService implements CalculateInterface {
    public double calculate(String value1, String operation, String value2) {
        value1 = value1.replace(",", ".");
        value2 = value2.replace(",", ".");
        if (operation.equals("+")) {
            return Double.valueOf(value1)+Double.valueOf(value2);
        } else if (operation.equals("-")) {
            return Double.valueOf(value1)-Double.valueOf(value2);
        }
        else if (operation.equals("*")) {
            return Double.valueOf(value1)*Double.valueOf(value2);
        }
        else if (operation.equals("/")) {
            return Double.valueOf(value1)/Double.valueOf(value2);
        }
        return 0;
    }
}
