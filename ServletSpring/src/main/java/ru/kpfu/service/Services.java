package ru.kpfu.service;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anatoly on 05.03.2017.
 */
@Component
public class Services {
    private Pattern pattern;
    private Matcher matcher;
    private static final String VALUE_REGULAR="^[0-9]+(\\.|,)?[0-9]*";

    public boolean validate(String s){
        pattern = Pattern.compile(VALUE_REGULAR);
        matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
