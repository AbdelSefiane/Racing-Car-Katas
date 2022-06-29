package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LOW_PRESSURE_THRESHOLD = 17;
    private final double HIGH_PRESSURE_THRESHOLD = 21;

    private final PressureSensor sensor;
    private boolean alarmOn = false;

    public Alarm() {
        this.sensor= new PressureSensor();
    }

    public Alarm(PressureSensor sensor) {
        this.sensor = sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.probe();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
