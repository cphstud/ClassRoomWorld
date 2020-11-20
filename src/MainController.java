import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    public void runProgram() {
        int mainChoice=0;
        int cityLimit = 0;
        List<City> cities = new ArrayList<>();
        while(mainChoice!=9) {
            switch (mainChoice) {
                case 1: cityLimit = findAllCUI();
                case 2: cities = findSomeC(cityLimit);
                case 3: findAllC();
                case 4: newCountry("SydSudan");
            }
        }

    }



    // ui services
    private int findAllCUI() {
        int retVal = 0;
        return retVal;
    }

    public int getUserSize() {
        int retVal = 0;
        // scanner snak

        return retVal;
    }


    // backend services
    private void newCountry(String sydSudan) {

    }

    public List<City> findSomeC(int limit) {
        int cityCount = 0;
        //preparedstatement that retrieves the count of all cities in the city table.
        // return count
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql = "";
        String collect = "";
        List<City> collectedCity = new ArrayList<>();
        City tmpCity = null;

        sql = "select * from world.city where Population > ? ";

        con = getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,limit);
            res = pstmt.executeQuery();
            while (res.next()) {
                int cityID = res.getInt("ID");
                String name = res.getString("Name");
                String countryCode = res.getString("CountryCode");
                String district = res.getString("CountryCode");
                int population = res.getInt("Population");
                tmpCity = new City(cityID,name,countryCode,district,population);
                collectedCity.add(tmpCity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collectedCity;
    }

    public List<Country> findAllCountries() {
        List<Country> countries = new ArrayList<>();

        //preparedstatement that retrieves the count of all cities in the city table.
        // return count
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql = "";
        Country country = null;
        City city = null;

        sql = "SELECT c.code, c.name, c.continent, ci.id, ci.name " +
                " FROM Country c, City ci " +
                " WHERE c.capital = ci.id";

        con = this.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();
            while (res.next()) {
                // hente ting til by
                int cityID = res.getInt(4);
                String cityName = res.getString(5);
                city = new City(cityID,cityName);
                String code = res.getString(1);
                String name = res.getString(2);
                String continent = res.getString(3);
                country = new Country(city,code,name,continent);
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public int findAllC() {

        int cityCount = 0;
        //preparedstatement that retrieves the count of all cities in the city table.
        // return count
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        String sql = "";

        sql = "select count(*) from world.city where Population > ? ";

        con = getConnection();
        try {
            pstmt = con.prepareStatement(sql);
            res = pstmt.executeQuery();
            if (res.next()) {
                cityCount = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityCount;
    }

    public Connection getConnection(){
        Connection con = null;
        String addOn = "serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/world?"+addOn;
        String user = "root";
        String pw = "root123";
        try {
            con = DriverManager.getConnection(url,user,pw);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }


}
