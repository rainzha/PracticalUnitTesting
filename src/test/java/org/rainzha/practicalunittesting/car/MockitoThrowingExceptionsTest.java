package org.rainzha.practicalunittesting.car;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoThrowingExceptionsTest {
    private Car myFerrari = mock(Car.class);

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(myFerrari.needsFuel())
                .thenThrow(new RuntimeException());
        myFerrari.needsFuel();
    }
}
