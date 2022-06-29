package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Random;

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

class PressureSensor implements Sensor<Double>{
    public static final double OFFSET = 16;

    @Override
    public Double probe() {
        double pressureTelemetryValue;
        pressureTelemetryValue = sample( );

        return OFFSET + pressureTelemetryValue;
    }

    private Double sample() {
        // placeholder implementation that simulate a real sensor in a real tire
        Random basicRandomNumbersGenerator = new Random();
        double pressureTelemetryValue = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
        return pressureTelemetryValue;
    }
}
