package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void checkShouldSetOffTheAlarmeWithLowPressureContext() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
        Sensor mock = mock(Sensor.class);
        alarm.sensor = mock;
        Mockito.when(mock.popNextPressurePsiValue()).thenReturn(15.0);
        alarm.check();
        assertEquals(true,alarm.isAlarmOn());
    }

    @Test
    public void checkShouldSetOffTheAlarmeWithHighPressureContext() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
        Sensor mock = mock(Sensor.class);
        alarm.sensor = mock;
        Mockito.when(mock.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        assertEquals(true,alarm.isAlarmOn());
    }
}
