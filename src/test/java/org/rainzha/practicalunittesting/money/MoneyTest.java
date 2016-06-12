package org.rainzha.practicalunittesting.money;

import org.junit.Test;
import org.rainzha.practicalunittesting.money.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");

        assertThat(money.getAmount()).isEqualTo(10);
        assertThat(money.getCurrency()).isEqualTo("USD");
    }
}