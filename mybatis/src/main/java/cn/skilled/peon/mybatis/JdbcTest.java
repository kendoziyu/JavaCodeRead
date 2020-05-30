package cn.skilled.peon.mybatis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.sql.*;
import java.util.UUID;

/**
 * 描述:  JDBC 测试 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/30 0030 <br>
 */
public class JdbcTest {

    private static final String JDBC_URL = "jdbc:mysql://192.168.3.20:3306/test?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "webtm2012";
    private Connection connection;

    @Before
    public void init() throws SQLException {
        DriverManager.setLogWriter(new PrintWriter(System.out));
        connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    @After
    public void autoClose() throws SQLException {
        if (connection != null)
            connection.close();
    }

    @Test
    public void testPreparedStatementExecute() {
        String sql = "INSERT INTO users(name, age, sex) values (?, 18, '女')";
        long begin = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 1; i <= 100; i++) {
                statement.setString(1, "用户"+ UUID.randomUUID());
                statement.execute(); // 单行执行
            }
            System.out.println(System.currentTimeMillis() - begin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPreparedStatementExecuteBatch() {
        String sql = "INSERT INTO users(name, age, sex) values (?, 22, '男')";
        long begin = System.currentTimeMillis();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 1; i <= 100; i++) {
                statement.setString(1, "用户"+ UUID.randomUUID());
                statement.addBatch(); // 加入到批量语句中
            }
            statement.executeBatch(); // 批处理
            System.out.println(System.currentTimeMillis() - begin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatementExecute() {
        String sql;
        long begin = System.currentTimeMillis();
        try (Statement statement = connection.createStatement()) {
            for (int i = 1; i <= 1000; i++) {
                sql = "INSERT INTO users(name, age, sex) values ('" + UUID.randomUUID() + "', 25, '女')";
                statement.executeUpdate(sql); // 单行执行
            }
            System.out.println(System.currentTimeMillis() - begin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatementExecuteBatch() {
        String sql;
        long begin = System.currentTimeMillis();
        try (Statement statement = connection.createStatement()) {
            for (int i = 1; i <= 1000; i++) {
                sql = "INSERT INTO users(name, age, sex) values ('" + UUID.randomUUID() + "',32, '男')";
                // 注意：addBatch 这个方法不能给 PreparedStatement 或者 CallableStatement 调用
                // 通常用于 INSERT 和 UPDATE 语句
                statement.addBatch(sql);
            }
            statement.executeBatch(); // 批处理
            System.out.println(System.currentTimeMillis() - begin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStatementSQLInjection() {
        String name = "metoo' or '1'='1";
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT phone_number FROM users where name='" + name + "'";
            System.out.println(sql);
            try (ResultSet rs = statement.executeQuery(sql)) {
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPreparedStatementSQLInjection() {
        String name = "metoo' or '1'='1";
        String sql = "SELECT phone_number FROM users where name=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            System.out.println(statement); // 打印转义后的sql
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryStatement() {
        try (Statement statement = connection.createStatement()) {
            statement.executeQuery("SELECT * FROM users WHERE sex = '女'");
            statement.executeQuery("SELECT * FROM users WHERE sex = '女'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryPrepareStatement() {
        // 预编译语句
        String sql = "SELECT name FROM users WHERE sex = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // 查询性别为男的用户
            statement.setString(1, "男");
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }

            // 查询性别为女的用户
            statement.setString(1, "女");
            statement.executeQuery();
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
