import com.mysql.jdbc.Driver;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;


//    public Config config = new Config();

//    public MySQLAdsDao() throws SQLException {
//        DriverManager.registerDriver(new Driver());
//        connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
//    }


    public MySQLAdsDao(Config config) {
        //            built into mysql package / new driver from mysql translates so we can use jave with it
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        } catch (SQLException error) {
            throw new RuntimeException("Error connecting to the db");
        }
    }


    @Override
    public List<Ad> all() {
//        create new "bucket" to place ads into
        List<Ad> allAds = new ArrayList<>();
        try {
//            Have to have statement to create queries
            Statement stmt = connection.createStatement();
            String showAds = "SELECT * FROM ads";
//            Cursor thru each row of data
            ResultSet rs = stmt.executeQuery(showAds);

            while (rs.next()) {
                allAds.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("userId"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return allAds;

        } catch (SQLException error) {
            throw new RuntimeException("Error retrieving all ads");
        }

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            String insertAdQuery = "INSERT INTO ads (user_id, title, description) VALUES" + "("
                    + ad.getUserId() + ","
                    + "'" + ad.getTitle() + "',"
                    + "'" + ad.getDescription() + "')";
//           in executeUpdate: want to have access to the new keys (id's) you're creating when new ad is created.
            stmt.executeUpdate(insertAdQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
//           rs.next starts at zero, reason for entering it once, then the next line
            return rs.getLong(1);
        } catch (SQLException error) {
//            throw new RuntimeException("Could not insert ad");
            error.printStackTrace();
        }
        return 0L;
    }

//    To simplify the above methods

//    private String createInsertQuery(Ad ad){
//        return String.format("INSERT INTO ads (user_id, title, description) VALUES(%d, '%s', '%s')",
//                ad.getUserId(), ad.getTitle(), ad.getDescription());
//    }
////
//    public Long insert(Ad ad) {
//        try {
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException error) {
//            throw new RuntimeException("Could not insert ad");
//        }
//    }


//    private Ad extractAd(ResultSet rs) throws SQLException {
//        return new Ad(rs.getLong("id"),
//                rs.getLong("userId"),
//                rs.getString("title"),
//                rs.getString("description"));
//    }
//
//    @Override
//    public List<Ad> all() {
////        create new "bucket" to place ads into
//        List<Ad> allAds = new ArrayList<>();
//        try {
////            Have to have statement to create queries
//            Statement stmt = connection.createStatement();
//            String showAds = "SELECT * FROM ads";
////            Cursor thru each row of data
//            ResultSet rs = stmt.executeQuery(showAds);
//
//            while (rs.next()) {
//                allAds.add(extractAd(rs));
//            }
//            return allAds;
//
//        } catch (SQLException error) {
//            throw new RuntimeException("Error retrieving all ads");
//        }
//
//    }

//    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
//        List<Ad> ads = new ArrayList<>();
//        while (rs.next()) {
//            ads.add(extractAd(rs));
//        }
//        return ads;
//    }
//
//    @Override
//    public List<Ad> all() {
//        try {
//            Statement stmt = connection.createStatement();
//            String showAds = "SELECT * FROM ads";
//            ResultSet rs = stmt.executeQuery(showAds);
//            return createAdsFromResults(rs);
//        } catch (SQLException error) {
//            throw new RuntimeException("Error retrieving all ads");
//        }
//    }


}
