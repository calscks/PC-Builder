package app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Seong Chee Ken on 10/03/2018.
 * Project Name: PC-Builder.
 * Single instance of database connection using singleton.
 */
public class DBConnection {
    private static DBConnection singleInstance;
    private Connection connection;
    private PreparedStatement statement;

    // prevent more than one instance caused by concurrency
    public static DBConnection getInstance() {
        if (singleInstance == null)
            synchronized (DBConnection.class) {
                if (singleInstance == null)
                    singleInstance = new DBConnection();
            }
        return singleInstance;
    }

    // prevent more than one instance caused by reflection API
    private DBConnection() {
        if (singleInstance != null)
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data.sqlite");
            execute(EType.UPDATE, "PRAGMA FOREIGN_KEYS = ON; PRAGMA JOURNAL_MODE = WAL;");
            System.out.println("connection established.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param type {@link EType} enumeration
     * @param sql SQL Statement to be executed
     * @return returns ResultSet whenever possible. Note that nothing will be returned if {@code EType.UPDATE} is used.
     */
    public ResultSet execute(EType type , String sql){
        try {
            statement = connection.prepareStatement(sql);
            if (type ==EType.QUERY)
                return statement.executeQuery();
            else if (type == EType.UPDATE){
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeStatement(){
        if (statement != null) {
            try {
                statement.close();
                System.out.println("Statement is closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeAll(){
        closeStatement();
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
