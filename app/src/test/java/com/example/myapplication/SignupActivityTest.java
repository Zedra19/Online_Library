package com.example.myapplication;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class SignupActivityTest {

    @Test
    public void containsOnlyNumbers_ValidInput_ReturnsTrue() {
        SignupActivity signupActivity = mock(SignupActivity.class);

        when(signupActivity.containsOnlyNumbers("12345")).thenReturn(true);
        when(signupActivity.containsOnlyNumbers("987654")).thenReturn(true);

        assertTrue(signupActivity.containsOnlyNumbers("12345"));
        assertTrue(signupActivity.containsOnlyNumbers("987654"));
    }

    @Test
    public void containsOnlyNumbers_InvalidInput_ReturnsFalse() {
        SignupActivity signupActivity = mock(SignupActivity.class);

        when(signupActivity.containsOnlyNumbers("abc123")).thenReturn(false);
        when(signupActivity.containsOnlyNumbers("12 34")).thenReturn(false);
        when(signupActivity.containsOnlyNumbers("123.45")).thenReturn(false);

        assertFalse(signupActivity.containsOnlyNumbers("abc123"));
        assertFalse(signupActivity.containsOnlyNumbers("12 34"));
        assertFalse(signupActivity.containsOnlyNumbers("123.45"));
    }

    @Test
    public void containsSymbol_ValidInput_ReturnsTrue() {
        SignupActivity signupActivity = mock(SignupActivity.class);

        when(signupActivity.containsSymbol("abcd@123")).thenReturn(true);
        when(signupActivity.containsSymbol("!@#%$&")).thenReturn(true);

        assertTrue(signupActivity.containsSymbol("abcd@123"));
        assertTrue(signupActivity.containsSymbol("!@#%$&"));
    }

    @Test
    public void containsSymbol_InvalidInput_ReturnsFalse() {
        SignupActivity signupActivity = mock(SignupActivity.class);

        when(signupActivity.containsSymbol("abcd123")).thenReturn(false);
        when(signupActivity.containsSymbol("abcde1234")).thenReturn(false);

        assertFalse(signupActivity.containsSymbol("abcd123"));
        assertFalse(signupActivity.containsSymbol("abcde1234"));
    }

    @Test
    public void containsCapitalLetter_ValidInput_ReturnsTrue() {
        SignupActivity signupActivity = mock(SignupActivity.class);

        when(signupActivity.containsCapitalLetter("Abcd123")).thenCallRealMethod();
        when(signupActivity.containsCapitalLetter("aBcD123")).thenCallRealMethod();
        when(signupActivity.containsCapitalLetter("ABC")).thenCallRealMethod();

        assertTrue(signupActivity.containsCapitalLetter("Abcd123"));
        assertTrue(signupActivity.containsCapitalLetter("aBcD123"));
        assertTrue(signupActivity.containsCapitalLetter("ABC"));
    }

    @Test
    public void containsCapitalLetter_InvalidInput_ReturnsFalse() {
        SignupActivity signupActivity = mock(SignupActivity.class);

        when(signupActivity.containsCapitalLetter("abcd123")).thenCallRealMethod();
        when(signupActivity.containsCapitalLetter("1234abcd")).thenCallRealMethod();
        when(signupActivity.containsCapitalLetter("!@#$%")).thenCallRealMethod();

        assertFalse(signupActivity.containsCapitalLetter("abcd123"));
        assertFalse(signupActivity.containsCapitalLetter("1234abcd"));
        assertFalse(signupActivity.containsCapitalLetter("!@#$%"));
    }
}