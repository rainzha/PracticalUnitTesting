package org.rainzha.practicalunittesting.car;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class FirstMockitoTest {
    private Car myFerrari = mock(Car.class);

    @Test
    public void testIfCarIsACar() {
        assertThat(myFerrari).isInstanceOf(Car.class);
    }
}
