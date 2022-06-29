package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AlarmTest {

    @Mock
    private static PressureSensor mock;
    private static Alarm alarm;

    @BeforeAll
    public static void setup() {
        MockitoAnnotations.initMocks(AlarmTest.class);
        alarm = new Alarm(mock);
    }

    @Test
    public void checkShouldSetOffTheAlarmeWithLowPressureContext() {
        Integer a = 1;

        assertFalse(alarm.isAlarmOn());
        Mockito.when(mock.probe())
                .thenReturn(15.0);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }

    @Test
    public void checkShouldSetOffTheAlarmeWithHighPressureContext() {
        PressureSensor mock = mock(PressureSensor.class);
        Alarm alarm = new Alarm(mock);
        assertFalse(alarm.isAlarmOn());
        Mockito.when(mock.probe())
                .thenReturn(22.0);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());
    }
}
