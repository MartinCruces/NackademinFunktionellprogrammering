package Uppkoppling_mot_databas.Skodatabas;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    private Properties login = new Properties();

    public Repository() {
        try {
            login.load(new FileInputStream("src/Uppkoppling_mot_databas/Skodatabas/settings.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    List<Shoe> getShoes() throws SQLException {

        try (
            Connection c = DriverManager.getConnection(
            login.getProperty("connectionString"),
            login.getProperty("loginName"),
            login.getProperty("password"));
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("select id, artikelnr , märke, färg, storlek, pris, lagersaldo from sko")){

            List<Shoe> shoes = new ArrayList<>();

                while(rs.next()) {

                Shoe temp = new Shoe();
                int id = rs.getInt("id");
                temp.setId(id);
                String articleNr = rs.getString("artikelnr");
                temp.setArticleNr(articleNr);
                String brand = rs.getString("märke");
                temp.setBrand(brand);
                String color = rs.getString("färg");
                temp.setColor(color);
                String size = rs.getString("storlek");
                temp.setSize(size);
                int price = rs.getInt("pris");
                temp.setPrice(price);
                int inventory = rs.getInt("lagersaldo");
                temp.setInventory(inventory);

                shoes.add(temp);
                }
                return shoes;
        }
    }

    List<Customer> getCustomer() throws  SQLException {

        try (
                Connection c = DriverManager.getConnection(
                        login.getProperty("connectionString"),
                        login.getProperty("loginName"),
                        login.getProperty("password"));
                Statement statement = c.createStatement();
                ResultSet rs = statement.executeQuery("select id, förnamn, lösenord from kund")){

            List<Customer> Customers = new ArrayList<>();

            while(rs.next()) {

                Customer customer = new Customer();
                int id = rs.getInt("id");
                customer.setId(id);
                String firstName = rs.getString("förnamn");
                customer.setFirstName(firstName);
                String passWord = rs.getString("lösenord");
                customer.setPassWord(passWord);
                Customers.add(customer);
            }

            return Customers;
        }
    }

    public void addToCart(int customerId, int newOrderId, int productId){

        try (Connection c = DriverManager.getConnection(
                login.getProperty("connectionString"),
                login.getProperty("loginName"),
                login.getProperty("password"));
             CallableStatement statement = c.prepareCall("call AddToCart(?,?,?)")) {

            statement.setInt(1, customerId);
            statement.setInt(2,newOrderId);
            statement.setInt(3, productId);
            statement.executeQuery();
            System.out.println("Order inlagd");

        } catch (SQLException e) {
            System.out.println("Beställningen gick inte att lägga in");
        }
    }
}
