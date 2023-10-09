package com.example.logistics.validation;

import com.example.logistics.enums.LoginType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoginTypeValidator implements ConstraintValidator<ValidLoginType, LoginType> {

    @Override
    public boolean isValid(LoginType loginType, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("============================ loginType :"+loginType);
        if(loginType == null){
            return true;
        }
        for(LoginType existingLoginType:LoginType.values() ){
            if(loginType.equals(existingLoginType)){
                return true;
            }
        }
        constraintValidatorContext.buildConstraintViolationWithTemplate("Hejlsajd").addConstraintViolation();
        return false;

    }
}
