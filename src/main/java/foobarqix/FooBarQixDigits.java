package foobarqix;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FooBarQixDigits {

    public FooBarQixDigits() {}

    public String append(int input) {

        return  Arrays.asList(String.valueOf(input).split(""))
                .stream()
                .map(c -> FooBar.textOfNumber(Integer.valueOf(c)))
                .collect(Collectors.joining());

    }
}
