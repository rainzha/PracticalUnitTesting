package org.rainzha.practicalunittesting.car;


import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockitoVerificationTest {
    private Car myFerrari = mock(Car.class);

    @Test
    public void testVerification() {
        myFerrari.driveTo("Sweet home Alabama");
        myFerrari.needsFuel();

        verify(myFerrari).driveTo("Sweet home Alabama");
        verify(myFerrari).needsFuel();
    }
}
