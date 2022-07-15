package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidatorTest{

    @Test
    void testValidateConstructorParameter() throws NoSuchMethodException {

        String firsName = "";
        String lastName = "";
        Address address = null;

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);
        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorParameters(constructor, new Object[]{firsName, lastName, address});
        for (ConstraintViolation<Object> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("====================");

        }
    }

    @Test
    void testValidateConstructorReturnValue() throws NoSuchMethodException {

        String firsName = "";
        String lastName = "";
        Address address = null;

        Person person = new Person(firsName,lastName, address);

        Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);
        Set<ConstraintViolation<Object>> violations = executableValidator
                .validateConstructorReturnValue(constructor, person);

        for (ConstraintViolation<Object> violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("====================");

        }
    }
}

