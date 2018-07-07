package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;


/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.jdbc
 * Create data: 01.07.2018 11:54
 */

public class SQLStorage {
    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "cross";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from users where id = ?");
            st.setInt(1, 7);
            st.executeUpdate();
            /*PreparedStatement st = conn.prepareStatement("update users set login  = ? where id = ?");
            st.setString(1, "Marina");
            st.setInt(2, 7);
            st.executeUpdate(); */

            /*PreparedStatement st = conn.prepareStatement("insert into users (login, password, create_date, role_id) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Marina");
            st.setString(2, "root");
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.setInt(4, 1);
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getInt(1));
            } */

            /*PreparedStatement st = conn.prepareStatement("SELECT * FROM users as u WHERE u.id in (?, ?, ?)");
            st.setInt(1, 1);
            st.setInt(2, 2);
            st.setInt(3,3);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                System.out.println(String.format("%s %s", rs.getString("login"), rs.getTimestamp("create_date")));
            }
            rs.close();
            st.close(); */

        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }

        }
    }
}
