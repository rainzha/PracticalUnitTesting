package org.rainzha.practicalunittesting.exercises.chapter03;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {
    private static final Object[] getCelciusToFahrenheitData() {
        return new Object[]{
                new Object[]{0, 32},
                new Object[]{37, 98},
                new Object[]{100, 212}
        };
    }

    @Test
    @Parameters(method = "getCelciusToFahrenheitData")
    public void shouldConvertCelciusToFahrenheit(int celcius, int excepted) {
        assertThat(FahrenheitCelciusConverter.toFahrenheit(celcius)).isEqualTo(excepted);
    }

    private static final Object[] getFahrenheitToCelciusData() {
        return new Object[]{
                new Object[]{32, 0},
                new Object[]{100, 37},
                new Object[]{212, 100}
        };
    }

    @Test
    @Parameters(method = "getFahrenheitToCelciusData")
    public void shouldConvertFahrenheitToCelcius(int fahrenheit, int excepted) {
        assertThat(FahrenheitCelciusConverter.toCelcius(fahrenheit)).isEqualTo(excepted);
    }
}
