package model;

public class AirportCode {
    private final String first;
    private final String second;
    private final String third;

    public AirportCode(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getCode() {
        return first + second + third;
    }
}
