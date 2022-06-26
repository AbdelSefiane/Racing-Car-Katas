package tddmicroexercises.leaderboard;

public class SelfDrivingCar implements Racer  {

    private String algorithmVersion;
    private String company;
    private String country;

    public SelfDrivingCar(String algorithmVersion, String company, String country) {
        this.algorithmVersion = algorithmVersion;
        this.company=company;
        this.country = country;
    }


    @Override
    public String getName() {
        return "Self Driving Car - " + this.company + " (" + this.algorithmVersion + ")";
    }
}
