package foobarqix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FooBarQixMultipleTest {

    FooBarQixMultiple fooBarQixMultiple = new FooBarQixMultiple();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_3(int coeff) {
        int input = 3 * coeff;
        Assertions.assertEquals("Foo", fooBarQixMultiple.append(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_5(int coeff) {
        int input = 5 * coeff;
        Assertions.assertEquals("Bar", fooBarQixMultiple.append(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_7(int coeff) {
        int input = 7 * coeff;
        Assertions.assertEquals("Qix", fooBarQixMultiple.append(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_15(int coeff) {
        int input = 3 * 5 * coeff;
        Assertions.assertEquals("FooBar", fooBarQixMultiple.append(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_21(int coeff) {
        int input = 3 * 7 * coeff;
        Assertions.assertEquals("FooQix", fooBarQixMultiple.append(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_35(int coeff) {
        int input = 5 * 7 * coeff;
        Assertions.assertEquals("BarQix", fooBarQixMultiple.append(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4})
    public void returns_foo_if_multiple_105(int coeff) {
        int input = 3 * 5 * 7 * coeff;
        Assertions.assertEquals("FooBarQix", fooBarQixMultiple.append(input));
    }

}
