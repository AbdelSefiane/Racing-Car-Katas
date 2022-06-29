package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls implements DiagnosticControl{
    private static final String DEFAULT_DIAGNOSTIC_CHANNEL_CONNECTION_STRING = "*111#";
    private final DistantProbe telemetryClient;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls() {
        telemetryClient = new TelemetryClient();
    }

    public String getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public void checkTransmission() throws Exception {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (!telemetryClient.isOnline() && retryLeft > 0) {
            telemetryClient.connect(DEFAULT_DIAGNOSTIC_CHANNEL_CONNECTION_STRING);
            retryLeft -= 1;
        }

        if (!telemetryClient.isOnline()) {
            throw new UnableToConnectException("Unable to connect.");
        }

        telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = telemetryClient.receive();
    }
}
