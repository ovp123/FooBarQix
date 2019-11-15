package stringcalculator;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculatorTest {
    @Test
    void test_with_no_arg() {
        Assertions.assertEquals(0,StringCalculator.add(""   ));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2","2,1","0,3"})
    void test_with_2_arg(String input) {
        Assertions.assertEquals(3,StringCalculator.add(input  ));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,4","-2,5","-10,13"})
    void test_with_2_arg_and_negative_numbers(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringCalculator.add(input));
    }

    @Test
    void test_with_1_arg() {
        Assertions.assertEquals(1,StringCalculator.add("1"   ));
    }

    @Test
    void test_with_5_arg_comma() {
        Assertions.assertEquals(5+2+4+36+51+4,StringCalculator.add("5,2,4,36,51,4"   ));
    }

    @Test
    void test_with_5_arg_comma_and_carriage() {
        Assertions.assertEquals(5+2+4+36+51+4,StringCalculator.add("5,2,4\n36,51,4"   ));
    }

    @Test
    void test_with_5_arg_carriage() {
        Assertions.assertEquals(5+2+4+36+51+4,StringCalculator.add("5\n2\n4\n36\n51\n4\n"   ));
    }

    @Test
    void test_with_2_arg_carriage() {
        Assertions.assertEquals(5+8,StringCalculator.add("5\n8"   ));
    }

    @Test
    void test_with_3_arg_carriage_ignore_thousands() {
        Assertions.assertEquals(5 + 8, StringCalculator.add("5\n8,1203"));
    }


    @Test
    void test_with_1_arg_carriage_ignore_thousands() {
        Assertions.assertEquals(0, StringCalculator.add("1203"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[***]\n1***2***3"})
    void test_with_2_arg_long_separator(String input) {
        Assertions.assertEquals(1 + 2 + 3, StringCalculator.add(input));
        Pattern compile = Pattern.compile("", Pattern.MULTILINE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[***][%]\n1***2%3"})
       void test_with_2_arg_long_2_separator(String input) {
        Assertions.assertEquals(1 + 2 + 3, StringCalculator.add(input));
        Pattern compile = Pattern.compile("", Pattern.MULTILINE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//[***][%][cds]\n1***2%3cds4"})
       void test_with_3_arg_long_3_separator(String input) {
        Assertions.assertEquals(1 + 2 + 3+4, StringCalculator.add(input));
        Pattern compile = Pattern.compile("", Pattern.MULTILINE);
    }

}
