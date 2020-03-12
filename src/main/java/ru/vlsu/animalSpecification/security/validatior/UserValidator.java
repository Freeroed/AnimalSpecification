package ru.vlsu.animalSpecification.security.validatior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "ErrorUserName");
        if(user.getUserName().length() < 8 || user.getUserName().length() > 48) {
            errors.rejectValue("username", "ERROR about size");
        }
        if(userService.findByUserName(user.getUserName())!=null){
            errors.rejectValue("name", "Duplicate User name");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 48) {
            errors.rejectValue("password", "Error password size");
        }


    }
}
