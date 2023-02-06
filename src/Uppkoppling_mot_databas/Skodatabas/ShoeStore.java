package Uppkoppling_mot_databas.Skodatabas;

import java.io.IOException;
import java.sql.*;import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;



public class ShoeStore {
    private int customerID;
    private int orderID;
    private int productID;

    private final Scanner scanner = new Scanner(System.in);

    public ShoeStore() throws SQLException, IOException {
        Repository repo = new Repository();
        Customer customer = new Customer();
        Shoe shoe = new Shoe();

        List<Customer> customerList = repo.getCustomer();
        List<Shoe> shoeList = repo.getShoes();

        System.out.println("Välkommen till ShoeStore");
        customerID = customer.getCustomerLoginId(customerList);
        customer.printOneCustomer(customerList, customerID);

        while (true) {
            System.out.println("har du ett ordnummer? Y/N");
            String answer = scanner.nextLine().trim().toUpperCase();
            if (Choice.N.toString().equals(answer)) {
                orderID = 0;
                break;
            } else if (Choice.Y.toString().equals(answer)) {
                while (true) {
                    System.out.println("Skriv in ditt ordernummer"); //TODO kolla mot beställningar
                    try {
                        orderID = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Ordernummer består bara av siffror");
                        scanner.next();
                    }
                }
                break;
            } else System.out.println("fel input");
        }

        System.out.println("Här är en lista av våra skor");
        shoe.printShoes(shoeList);
        List<Shoe> oneShoe = shoe.getCustomerChooseOrder(shoeList);
        productID = shoe.getShoeID(oneShoe);
        repo.addToCart(customerID, orderID, productID);
        shoe.printShoes(oneShoe);
        customer.printOneCustomer(customerList, customerID);
    }


    public static void main(String[] args) throws SQLException, IOException {


        ShoeStore orderMaker = new ShoeStore();


    }
}
