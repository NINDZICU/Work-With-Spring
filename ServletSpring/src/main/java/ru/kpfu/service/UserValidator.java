package ru.kpfu.service;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.entities.UserValid;

/**
 * Created by Anatoly on 04.04.2017.
 */
public class UserValidator implements Validator {
    public boolean supports(Class clazz) {
        return UserValid.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty", "field mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "surname", "email.empty", "field mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "email.empty", "field mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "password", "email.empty", "field mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "repassword", "email.empty", "field mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "country", "email.empty", "field mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "gender", "email.empty", "Select something");

        UserValid user = (UserValid) obj;
        if(!user.getEmail().matches("^[a-zA-Z0-9_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,8}$")){
            e.rejectValue("email", "email.incorrect");
        }
        if(user.getName().length()>128) e.rejectValue("name", "name.incorrect",new Object[]{},"Name must be less than 128 characters");
        if(user.getSurname().length()>128) e.rejectValue("surname","surname.incorrect",new Object[]{}, "Surname must be less than 128 characters");
        if(user.getCountry().length()>128) e.rejectValue("country", "country.incorrect",new Object[]{},"Country must be less than 128 characters");
        if(user.getPassword().length()<6&&user.getPassword().length()>128) e.rejectValue("password","password.incorrect",new Object[]{}, " The password must be at least 6 characters and less than 128 characters");
        if(!user.getRepassword().equals(user.getPassword())) e.rejectValue("repassword","repassword.incorrect",new Object[]{}, " The repassword must be match with password");
    }
}
