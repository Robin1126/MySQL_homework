package DButils;

import java.sql.*;
import java.util.ResourceBundle;

public class DButils {

    // 加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DButils() {
    }

    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("Info");
        return DriverManager.getConnection(rb.getString("url"),rb.getString("userName"),rb.getString("password"));
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
