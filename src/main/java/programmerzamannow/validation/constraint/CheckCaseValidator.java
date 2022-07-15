package programmerzamannow.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import programmerzamannow.validation.enums.CaseMode;

import java.util.Locale;

public abstract class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        caseMode = constraintAnnotation.mode();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value ==null) return true;

        if (caseMode == CaseMode.UPPER){
            return value.equals(value.toUpperCase());
        }else if(caseMode==CaseMode.LOWER){
            return value.equals(value.toUpperCase(Locale.ROOT));
        }

        return false;
    }
}
