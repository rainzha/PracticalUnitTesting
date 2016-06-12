package org.rainzha.practicalunittesting.money;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rainzha.practicalunittesting.money.Money;

@RunWith(JUnitParamsRunner.class)
public class MoneyIAETest {
    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object[] getInvalidAmount() {
        return new Integer[][]{{-12387}, {-5}, {-1}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void constructorShouldThrowIAEForInvalidAmount(
            int invalidAmount) {
        new Money(invalidAmount, VALID_CURRENCY);
    }

    private static final Object[] getInvalidCurrency() {
        return new String[][]{{null}, {""}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(
            String invalidCurrency) {
        new Money(VALID_AMOUNT, invalidCurrency);
    }
}