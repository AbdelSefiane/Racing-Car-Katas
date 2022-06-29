package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tddmicroexercises.telemetrysystem.TelemetryClient.DEFAULT_DIAGNOSTIC_REPORT;
import static tddmicroexercises.telemetrysystem.TelemetryClient.DIAGNOSTIC_MESSAGE;

public class TelemetryDiagnosticControlsTest {
    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() {
        Random rand = mock(Random.class);
        when(rand.nextInt(Mockito.anyInt())).thenReturn(6);
        TelemetryClient client = new TelemetryClient(rand);
        client.connect("some-connection-string");
        client.send(DIAGNOSTIC_MESSAGE);
        String receive = client.receive();
        assertEquals(DEFAULT_DIAGNOSTIC_REPORT, receive);
    }

}
