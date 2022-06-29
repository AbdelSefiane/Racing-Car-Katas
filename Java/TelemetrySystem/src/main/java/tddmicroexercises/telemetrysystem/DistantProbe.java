package tddmicroexercises.telemetrysystem;

public interface DistantProbe {

    public boolean isOnline();
    public void connect(String connectionString);

    public void disconnect();

    public void send(String message);

    public String receive();
}
