import javax.swing.plaf.synth.Region;

public class Country {
    String Code ;
    String Name ;
    String Continent ;
    String Region ;
    double SurfaceArea ;
    int IndepYear ;
    int Population ;
    double LifeExpectancy ;
    double GNP ;
    double GNPOld ;
    String LocalName ;
    String GovernmentForm ;
    City Capital ;

    public Country(City capital,String code, String name, String continent) {
        this.Capital = capital;
        Code = code;
        Name = name;
        Continent = continent;
    }
}
