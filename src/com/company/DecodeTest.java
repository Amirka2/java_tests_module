package com.company;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecodeTest {
    @Test(expectedExceptions = NumberFormatException.class)     //zero length
    public void empty_string() {
        Integer.decode("");
    }

    @Test
    public void negated_integer() {
        assertEquals(-1, Integer.decode("-1"));
    }
    @Test
    public void positive_integer() {
        assertEquals(1, Integer.decode("+1"));
    }

    @Test
    public void hex() {
        assertEquals(1, Integer.decode("0x1"));
    }
    @Test
    public void negative_hex() {
        assertEquals(-1, Integer.decode("-0x1"));
    }

    @Test
    public void another_hex() {
        assertEquals(1, Integer.decode("0x1"));
    }
    @Test
    public void another_negative_hex() {
        assertEquals(-1, Integer.decode("-0x1"));
    }

    @Test
    public void hashtag_hex() {
        assertEquals(1, Integer.decode("#1"));
    }
    @Test
    public void negative_hashtag_hex() {
        assertEquals(-1, Integer.decode("-#1"));
    }

    @Test
    public void oct_decimal() {
        assertNotEquals(12, Integer.decode("012"));
    }
    @Test
    public void oct() {
        assertEquals(15, Integer.decode("017"));
    }

    @Test
    public void zero() {
        assertEquals(0, Integer.decode("000"));
    }

    @Test
    public void insignificant_zero() {
        assertEquals(1, Integer.decode("0001"));
    }

    @Test
    public void positive_and_negative_zeroes() {
        assertEquals(Integer.decode("+0"), Integer.decode("-0"));
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void minus_after_prefix() {
        Integer.decode("0x-1");
    }
    @Test(expectedExceptions = NumberFormatException.class)
    public void plus_after_prefix() {
        Integer.decode("0x+1");
    }

    @Test
    public void integer_min_value() {
        String min = String.valueOf(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, Integer.decode(min));
    }
    @Test
    public void integer_max_value() {
        String max = String.valueOf(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, Integer.decode(max));
    }

    @Test(expectedExceptions = NumberFormatException.class)
    protected void incorrect_input() {
        Integer.decode("abc");
    }
}
