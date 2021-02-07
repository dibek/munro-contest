package org.dibek.munro.validator;

import org.dibek.munro.domain.MunroInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MunroInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MunroInfo.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MunroInfo munroInfo = (MunroInfo)  target;
        if (munroInfo.getMinHeight() != null && munroInfo.getMaxHeight() != null) {
            if (munroInfo.getMinHeight().compareTo(munroInfo.getMaxHeight()) > 0) {
                errors.rejectValue("minimumHeight", ErrorCodes.MINHEIGHTHIGHERMAXHEIGHT.code);
            }
            if (munroInfo.getMaxHeight().compareTo(munroInfo.getMinHeight()) < 0) {
                errors.rejectValue("maximumHeight",  ErrorCodes.MAXHEIGHTLOWERMINHEIGHT.code);
            }
        }
    }
}
