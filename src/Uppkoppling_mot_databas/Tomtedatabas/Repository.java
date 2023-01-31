package Uppkoppling_mot_databas.Tomtedatabas;

import Uppkoppling_mot_databas.Skodatabas.Shoe;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {
    private Properties login = new Properties();
    private Connection connection;

    public Repository() {
        try {
            login.load(new FileInputStream("src/Uppkoppling_mot_databas/Tomtedatabas/settings.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Child getChildByName(String name) {

        try (Connection c = DriverManager.getConnection(
                login.getProperty("connectionString"),
                login.getProperty("loginName"),
                login.getProperty("password"));
             PreparedStatement statement = c.prepareStatement("SELECT * FROM child WHERE name= ?")) {
            ;


            //ResultSet rs = statement.executeQuery("SELECT * FROM child WHERE name='" + name + "'" )){
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            Child child = null;

            while (rs.next()) {
                child = new Child(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("nice"));
            }
            return child;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertChild(String name, String address, int countryId, boolean nice) {
        try (Connection c = DriverManager.getConnection(
                login.getProperty("connectionString"),
                login.getProperty("loginName"),
                login.getProperty("password"));
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO child (name, address, countryId, nice) VALUES (?,?,?,?)")) {

            statement.setString(1, name);
            statement.setString(2, address);
            statement.setInt(3, countryId);
            statement.setBoolean(4, nice);
            int rs = statement.executeUpdate();

            System.out.println(rs + " rader uppdaterade");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
