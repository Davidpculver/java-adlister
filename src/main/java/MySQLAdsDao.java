import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;
    public Config config = new Config();

    public MySQLAdsDao() throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
    }

    @Override
    public List<Ad> all() {
        List<Ad> newList = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement();
            String selectQuery = "SELECT * FROM ads";
            ResultSet rs = stmt.executeQuery(selectQuery);

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        };
return newList;
    }

    @Override
    public Long insert(Ad ad) {

    }
}
