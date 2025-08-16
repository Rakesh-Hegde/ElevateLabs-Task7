import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));

            String URL = props.getProperty("db.url");
            String USER = props.getProperty("db.user");
            String PASSWORD = props.getProperty("db.password");

            // Always return a fresh connection
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
