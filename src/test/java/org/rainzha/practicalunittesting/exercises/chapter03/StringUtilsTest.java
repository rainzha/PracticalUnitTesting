package org.rainzha.practicalunittesting.exercises.chapter03;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class StringUtilsTest {
    private static final Object[] getString() {
        return new Object[]{
                new Object[]{"ab", "ba"},
                new Object[]{"aca", "aca"},
                new Object[]{"abbc", "cbba"},
                new Object[]{"aaa", "aaa"},
                new Object[]{" ", " "},
                new Object[]{"", ""}
        };
    }

    @Test
    @Parameters(method = "getString")
    public void stringReverse(String s, String excepted) {
        assertThat(StringUtils.reverse(s)).isEqualTo(excepted);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionForNullString() {
        StringUtils.reverse(null);
    }
}