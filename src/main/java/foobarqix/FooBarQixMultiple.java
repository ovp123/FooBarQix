package foobarqix;

public class FooBarQixMultiple {

    public FooBarQixMultiple() {}

    public String append(int input) {
        StringBuilder result = new StringBuilder();

        if (input % FooBar.FOO_VALUE == 0) result.append(FooBar.textOfNumber(FooBar.FOO_VALUE));
        if (input % FooBar.BAR_VALUE == 0) result.append(FooBar.textOfNumber(FooBar.BAR_VALUE));
        if (input % FooBar.QIX_VALUE == 0) result.append(FooBar.textOfNumber(FooBar.QIX_VALUE));

        return result.toString();
    }

}
