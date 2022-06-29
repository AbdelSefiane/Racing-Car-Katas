package tddmicroexercises.telemetrysystem;

public interface DiagnosticControl {

    public String getDiagnosticInfo();

    public void checkTransmission() throws Exception;
}
