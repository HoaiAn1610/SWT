package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    protected final Connection connection;

    public DBContext() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // hoặc: jdbc:sqlserver://localhost;instanceName=HOAIAN;databaseName=OFS5
            String url = "jdbc:sqlserver://localhost:1433;databaseName=OFS4";
            this.connection = DriverManager.getConnection(url, "sa", "12345");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Không thể kết nối tới database", ex);
        }
        if (this.connection == null) {
            throw new IllegalStateException("DBContext error: connection is null");
        }
    }

    /** Trả về Connection, caller phải đóng Statement/ResultSet */
    public Connection getConnection() {
        return connection;
    }
}
