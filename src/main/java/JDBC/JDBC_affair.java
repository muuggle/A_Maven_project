package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

//public class JDBC_affair {
//    public static void main(String[] args) throws SQLException {
//        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false";
//        String JDBC_USER = "root";
//        String JDBC_PASSWORD = "zxn1998312";
//
//        Connection conn = openConnection();
//        try {
//            // 关闭自动提交:
//            conn.setAutoCommit(false);
//            // 执行多条SQL语句:
//            insert();
//            update();
//            delete();
//            // 提交事务:
//            conn.commit();
//        } catch (SQLException e){
//            conn.rollback();
//        } finally{
//            conn.setAutoCommit(true);
//            conn.close();
//        }
//    }
//}


