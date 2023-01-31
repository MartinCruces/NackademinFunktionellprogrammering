package Uppkoppling_mot_databas.Skodatabas;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    List<Shoe> getShoes() throws IOException, SQLException {
        Properties login = new Properties();
        login.load(new FileInputStream("src/Uppkoppling_mot_databas/Skodatabas/settings.properties"));

        try (
            Connection c = DriverManager.getConnection(
            login.getProperty("connectionString"),
            login.getProperty("loginName"),
            login.getProperty("password"));
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("select id, märke, färg from sko")){

            List<Shoe> shoes = new ArrayList<>();

                while(rs.next()) {

                Shoe temp = new Shoe();
                int id = rs.getInt("id");
                temp.setId(id);
                String brand = rs.getString("märke");
                temp.setBrand(brand);
                String color = rs.getString("färg");
                temp.setColor(color);
                shoes.add(temp);
                }


                return shoes;
        }
    }
}
