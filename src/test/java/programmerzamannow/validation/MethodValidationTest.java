package programmerzamannow.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidatorTest{

    @Test
    void testSayHello() throws NoSuchMethodException {
        Person person = new Person();

        String name = "";

        Method method = Person.class.getMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.
                validateParameters(person, method, new Object[]{name});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("=============");

        }
    }

    @Test
    <T>
    void testFullName() throws NoSuchMethodException {
        Person person =new Person();
        person.setFirstName("Eko");
        person.setLastName("");

        String returnValue = person.fullName();
        Method method = Person.class.getMethod("fullName");

        for (ConstraintViolation<Person> violation : executableValidator
                .validateReturnValue(person, method, returnValue)) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());

        }
    }
}
