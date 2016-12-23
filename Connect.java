import java.sql.*;

public class Connect {
    
    public Connect() throws SQLException {
        makeConnection();
    }
    private Connection conn;
    
    public Connection makeConnection() throws SQLException {
        
        if(conn== null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/medialib","user1","user1");
        }
        return conn;
    }
    public Statement makeStatement() throws SQLException {
        
        Statement report = conn.createStatement();
        return report;
    }
    public int close() throws SQLException {
        conn.close();
        return 1;
    }
}