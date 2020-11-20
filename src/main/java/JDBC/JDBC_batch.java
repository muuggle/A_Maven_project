package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class JDBC_batch {
//    public static void main(String[] args) throws SQLException {
//        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false";
//        String JDBC_USER = "root";
//        String JDBC_PASSWORD = "zxn1998312";
//
//        try(Connection conn= DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD)){
//            try(PreparedStatement ps=
//                        conn.prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")){
//                for (Student s:students){
//                    ps.setString(1, s.name);
//                    ps.setBoolean(2, s.gender);
//                    ps.setInt(3, s.grade);
//                    ps.setInt(4, s.score);
//                    ps.addBatch();
//                }
//                int[] ns=ps.executeBatch();
//                for (int n:ns){
//                    System.out.println(n + " inserted.");
//                }
//            }
//        }
//    }
//}
public class JDBC_batch {

    public static void main(String[] args) throws Exception {
        batchInsertStudents(List.of("大黄", "小黑", "大头"));
        List<Student> students = queryStudents();
        students.forEach(System.out::println);
    }

    static void batchInsertStudents(List<String> names) throws SQLException {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            boolean isAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false); // 关闭自动提交事务
            try (PreparedStatement ps = conn
                    .prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
                for (String name : names) {
                    ps.setString(1, name);
                    ps.setBoolean(2, false);
                    ps.setInt(3, 3);
                    ps.setInt(4, 99);
                    ps.addBatch(); // 添加到batch
                }
                int[] ns = ps.executeBatch(); // 执行batch
                for (int n : ns) {
                    System.out.println(n + " inserted."); // batch中每个SQL执行的结果数量
                }
            }
            conn.commit();
            conn.setAutoCommit(isAutoCommit); // 恢复AutoCommit设置
        }
    }

    static List<Student> queryStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE grade = ? AND score = ?")) {
                ps.setInt(1, 3); // 第一个参数grade=?
                ps.setInt(2, 99); // 第二个参数score=?
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        return students;
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        var std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }

    static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?useSSL=false&characterEncoding=utf8";
    static final String jdbcUsername = "learn";
    static final String jdbcPassword = "learnpassword";
}