package hbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ³¾¶« on 2017/3/23.
 */
public class Test01 {
    public static void main(String[] args) throws SQLException {
        String diamondGroup="hbase-diamond-group-name-test";
        String diamonDataID="hbase.diamond.dataid.test.hbase";
        Connection conn = DriverManager.getConnection("jdbc:hbase:diamond-"+diamondGroup+":/"+diamonDataID);
        System.out.println(conn);
    }
}
