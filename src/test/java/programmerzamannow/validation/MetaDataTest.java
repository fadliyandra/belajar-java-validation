package programmerzamannow.validation;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

public class MetaDataTest extends  AbstractValidatorTest{

    @Test
    void testPerson() {

        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);

        for (PropertyDescriptor constrainedProperty : beanDescriptor.getConstrainedProperties()) {
            System.out.println(constrainedProperty.getPropertyName());

        }

    }
}
