package foobarqix;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FooBarTest {

    @Mock
    FooBarQixDigits fooBarQixDigits;

    @Mock
    FooBarQixMultiple fooBarQixMultiple;

    @InjectMocks
    FooBar fooBar;

    @Test
    public void it_should_be_a_positive_number() {
        int input = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new FooBar().fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 401})
    public void returns_foo_if_no_multiple(int input) {
        Assertions.assertEquals("" + input, new FooBar().fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 36, 39})
    public void returns_foo_if_both_multiple_and_digits(int input) {
        Assertions.assertEquals("FooFoo", new FooBar().fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 36, 39})
    public void returns_null_with_Mocks(int input) {
        Assertions.assertEquals("nullnull", fooBar.fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {13,31})
    public void returns_foo_if_only_digits_3(int input) {
        Assertions.assertEquals("Foo", new FooBar().fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {52})
    public void returns_foo_if_only_digits_5(int input) {
        Assertions.assertEquals("Bar", new FooBar().fooBarQix(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {17})
    public void returns_foo_if_only_digits_7(int input) {
        Assertions.assertEquals("Qix", new FooBar().fooBarQix(input));
    }


}
