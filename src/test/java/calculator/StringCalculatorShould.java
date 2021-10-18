package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    public void string_calculateTwo_expectTwo() {
        Assert.assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void string_calculateTwoToOne_expectThree() {
        Assert.assertEquals(3, StringCalculator.add("2,1"));
    }

    @Test
    public void string_calculateTwoToOneWithNewlines_expectThree() {
        Assert.assertEquals(3, StringCalculator.add("2\n1"));
    }

    @Test
    public void string_calculateTwoToOneWithCustomDelimiter_expectThree() {
        Assert.assertEquals(3, StringCalculator.add("//[x]\n2x1"));
    }

    @Test
    public void string_calculateTwoToOneWithCustomDelimiterWithLengthTwo_expectThree() {
        Assert.assertEquals(3, StringCalculator.add("//[xx]\n2xx1"));
    }

    @Test
    public void string_calculateTwoToOneToThreeWithTwoCustomDelimiter_expectThree() {
        Assert.assertEquals(6, StringCalculator.add("//[x][y]\n2x1y3"));
    }

    @Test
    public void string_calculateSingleNegativeValue_exception() {
        try {
            StringCalculator.add("-1");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed (-1)", e.getMessage());
        }
    }

    @Test
    public void string_calculateTwoNegativeValue_exception() {
        try {
            StringCalculator.add("-1,-2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed (-1,-2)", e.getMessage());
        }
    }

    @Test
    public void string_calculateTwoToOneThousandOne_Two() {
        Assert.assertEquals(2, StringCalculator.add("2,1001"));
    }
}
