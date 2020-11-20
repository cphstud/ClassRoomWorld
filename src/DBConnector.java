import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getConnection() {
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
