package JDBC;

import java.sql.*;

public class JDBC_update {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "zxn1998312";
//插入
//        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//            try (PreparedStatement ps = conn.prepareStatement(
//                    "INSERT INTO students (id, grade, name, gender,score) VALUES (?,?,?,?,?)"
//            )) {
//                ps.setObject(1, 999); // 注意：索引从1开始
//                ps.setObject(2, 1); // grade
//                ps.setObject(3, "Bob"); // name
//                ps.setObject(4, 1); // gender
//                ps.setObject(5,99);
//                int n=ps.executeUpdate();
//            }
//        }

//插入并获取主键
//        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//            try (PreparedStatement ps = conn.prepareStatement(
//                    "INSERT INTO students (id, grade, name, gender,score) VALUES (?,?,?,?,?)",
//                    Statement.RETURN_GENERATED_KEYS
//            )) {
//                ps.setObject(1, 98); // 注意：索引从1开始
//                ps.setObject(2, 2); // grade
//                ps.setObject(3, "Bfhje"); // name
//                ps.setObject(4, 0); // gender
//                ps.setObject(5, 60);
//                int n = ps.executeUpdate();
//                try (ResultSet rs = ps.getGeneratedKeys()) {
//                    if (rs.next()) {
//                        long id = rs.getLong(1);
//                        System.out.println(id);
//                    }
//                }
//            }
        //更新
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)){
            try (PreparedStatement ps= conn.prepareStatement("delete from students where id=?")){
                ps.setObject(1,98);
                int n =ps.executeUpdate();
            }
        }
    }
}
