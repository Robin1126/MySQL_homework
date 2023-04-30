package DButils;

import java.sql.*;
import java.util.ResourceBundle;
/**/
public class DButils {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.Info");
    private static String className = resourceBundle.getString("className");

    private static String url = resourceBundle.getString("url");
    private static String userName = resourceBundle.getString("userName");
    private static String password = resourceBundle.getString("password");

    static {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 加载驱动
    /*
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    private DButils() {
    }

    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    // 释放资源
    public static void close(ResultSet rs, Statement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
