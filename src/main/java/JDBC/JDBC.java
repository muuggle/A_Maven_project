package JDBC;

import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "zxn1998312";

//        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
//            try (Statement stmt = conn.createStatement()) {
//                try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
//                    while (rs.next()) {
//                        long id = rs.getLong(1);
//                        long grade = rs.getLong(2);
//                        String name = rs.getString(3);
//                        int gender = rs.getInt(4);
//                    }
//                    conn.close();
//                }
//            }
//        }
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps =
                         conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? and grade=?")) {
                ps.setObject(1, "M");
                ps.setObject(2, 3);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println(id);
                        System.out.println(grade);
                        System.out.println(name);
                        System.out.println(gender);
                    }
                }
                conn.close();
            }
        }
    }
}
