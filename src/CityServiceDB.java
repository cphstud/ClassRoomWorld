import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityServiceDB implements CityI{

    @Override
    public List<City> findSomeC() {
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

        sql = "select * from world.city where Population > 500000";

        con = DBConnector.getConnection();
        try {
            pstmt = con.prepareStatement(sql);
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
}
