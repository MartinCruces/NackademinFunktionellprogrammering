package Uppkoppling_mot_databas.Skodatabas;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    private final Properties login = new Properties();

    final Connection getConnection () throws SQLException {
            Connection connection =  DriverManager.getConnection(login.getProperty("connectionString"),
                       login.getProperty("loginName"),
                       login.getProperty("password"));
        return connection;
    }

    public Repository() {
        try {
            login.load(new FileInputStream("src/Uppkoppling_mot_databas/Skodatabas/settings.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    List<Shoe> getShoes() throws SQLException {

        try (Connection connect= getConnection();
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("select id, artikelnr , märke, färg, storlek, pris, lagersaldo from sko")){

            List<Shoe> shoes = new ArrayList<>();

                while(rs.next()) {
                    int id = rs.getInt("id");
                    String articleNr = rs.getString("artikelnr");
                    String brand = rs.getString("märke");
                    String color = rs.getString("färg");
                    String size = rs.getString("storlek");
                    int price = rs.getInt("pris");
                    int inventory = rs.getInt("lagersaldo");
                    Shoe temp = new Shoe(id, articleNr, brand, color, size, price, inventory);
                    shoes.add(temp);
                }
                return shoes;
        }
    }

    List<Customer> getCustomer() throws  SQLException {

        try (Connection connect= getConnection();
                Statement statement = connect.createStatement();
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

        try (Connection connect= getConnection();
             CallableStatement statement = connect.prepareCall("call AddToCart(?,?,?)")) {

            statement.setInt(1, customerId);
            statement.setInt(2,newOrderId);
            statement.setInt(3, productId);
            statement.executeQuery();
            System.out.println("Följande beställning inlagd: ");

        } catch (SQLException e) {
            System.out.println("Följande beställningen gick inte att lägga in:");
        }
    }
}
