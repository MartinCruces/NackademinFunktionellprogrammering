package Uppkoppling_mot_databas.Skodatabas;


import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ConnectToShoeDataBase {

    public static void main(String[] args) throws SQLException, IOException {
        Repository repo = new Repository();

        List<Shoe> shoeList = repo.getShoes();
        shoeList.forEach(shoe -> System.out.println(shoe.getId() + " " + shoe.getBrand() + " " + shoe.getColor()));

    }
}
