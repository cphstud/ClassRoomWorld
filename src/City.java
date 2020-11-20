public class City {
    private int cityID;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    public City(int cityID, String name, String countryCode, String district, int population) {
        this.cityID = cityID;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public City(int cityID,String name) {
        this.cityID = cityID;
        this.name = name;
    }

    @Override
    public String toString() {
        String msg = "";
        msg += name + ";";
        msg += cityID + ";";
        msg += countryCode + ';';
        msg += district + ';';
        msg += population + ';';

        return msg;
    }
}
