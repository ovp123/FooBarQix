package foobarqix;

import java.util.*;
import java.util.stream.Collectors;

public class FooBar {

    static final int FOO_VALUE = 3;
    static final int BAR_VALUE = 5;
    static final int QIX_VALUE = 7;
    FooBarQixDigits fooBarQixDigits;
    FooBarQixMultiple fooBarQixMultiple;

    public FooBar() {
        this(new FooBarQixDigits(), new FooBarQixMultiple());
    }

    public FooBar(FooBarQixDigits fooBarQixDigits, FooBarQixMultiple fooBarQixMultiple) {
        this.fooBarQixDigits = fooBarQixDigits;
        this.fooBarQixMultiple = fooBarQixMultiple;
    }

    public String fooBarQix(int input) {

        if (input < 0) throw new IllegalArgumentException("input must be positive");

        String result = fooBarQixMultiple.append(input) + fooBarQixDigits.append(input);
        return (result.length() == 0) ? input + "" : result;

    }


    public static String textOfNumber(int number) {
        switch (number) {
            case FOO_VALUE:
                return "Foo";
            case BAR_VALUE:
                return "Bar";
            case QIX_VALUE:
                return "Qix";
        }
        return "";
    }

}