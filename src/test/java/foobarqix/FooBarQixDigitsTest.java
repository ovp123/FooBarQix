package foobarqix;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

//@ExtendedWith(MockitoExtension.class)
public class FooBarQixDigitsTest {

    FooBarQixDigits fooBarQixDigits = new FooBarQixDigits();

    @ParameterizedTest
    @ValueSource(ints = {33,334,1343})
    public void returns_foo_if_digits_33(int number) {
        Assertions.assertEquals("FooFoo",fooBarQixDigits.append(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {35,354,1345})
    public void returns_foo_if_digits_35(int number) {
        Assertions.assertEquals("FooBar",fooBarQixDigits.append(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {137,374,1347})
    public void returns_foo_if_digits_37(int number) {
        Assertions.assertEquals("FooQix",fooBarQixDigits.append(number));
    }


    @ParameterizedTest
    @ValueSource(ints = {153,534,5123})
    public void returns_foo_if_digits_53(int number) {
        Assertions.assertEquals("BarFoo",fooBarQixDigits.append(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {537735,195347735,59387735})
    public void returns_foo_if_digits_537735(int number) {
        Assertions.assertEquals("BarFooQixQixFooBar",fooBarQixDigits.append(number));
    }


}
