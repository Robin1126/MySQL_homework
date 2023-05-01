package homework02;

import DButils.DButils;
import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.SQLException;

public class homework2 {
    public static void main(String[] args) {
        try {
            Connection conn = DButils.getConnection();
            Resultset rs = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
