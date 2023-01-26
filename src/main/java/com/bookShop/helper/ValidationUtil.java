package com.bookShop.helper;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Hakim
 */
public class ValidationUtil {
    private static final ValidationUtil INSTANCE=new ValidationUtil();
    private final Validator validator;
    
    public static ValidationUtil getINSTANCE() {
        return INSTANCE;
    }
    
    private ValidationUtil(){
        var validationFactory=Validation.buildDefaultValidatorFactory();
        validator=validationFactory.getValidator();
    }
    
    public <T> Map<String,String> validate(T object){
        var violations=validator.validate(object);
        return violations.stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage,
                        (String errorMsg1,String errorMsg2)->errorMsg1+"<br/>"+errorMsg2
                ));
    }
}
