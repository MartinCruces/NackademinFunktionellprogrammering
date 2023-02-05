package Uppkoppling_mot_databas.Skodatabas;


import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ShoeStore {

    private final Scanner scanner = new Scanner(System.in);

    private void login(){


    }

    public ShoeStore() throws SQLException, IOException {
        Repository repo = new Repository();
        Customer customer = new Customer();
        Shoe shoe = new Shoe();

        List<Customer> customerList = repo.getCustomer();
        List<Shoe> shoeList = repo.getShoes();
        int customerID;
        int orderID;
        int productID;

        System.out.println("Välkommen till ShoeStore");
        while(true) {
            System.out.println("För att logga in skriv ditt förnamn:");
            String firstName = scanner.nextLine().trim();
            System.out.println("Skriv in ditt lösenord");
            String passWord = scanner.nextLine().trim();
            List<Customer> temp = customer.confirmCustomer(customerList, firstName, passWord);
            if (temp.isEmpty()) {
                System.out.println("Namn eller lösenord är fel");

            } else {
                customerID = customer.getCustomerID(temp);
                break;
            }
        }

        while (true){
            System.out.println("har du ett ordnummer? Y/N");
            String answer = scanner.nextLine().trim().toUpperCase();
            if(Choice.N.toString().equals(answer)){
                orderID = 0;
                break;
            }
            else if (Choice.Y.toString().equals(answer)) {
                while (true){

                    System.out.println("Skriv in ditt ordernummer"); //TODO kolla mot beställningar
                    try {
                        orderID = scanner.nextInt();
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Ordernummer består bara av siffror");
                        scanner.next();
                    }
                }
                break;
            }
            else System.out.println("fel input");
        }

        System.out.println("Här är en lista av våra skor");
        shoe.printShoes(shoeList);

        scanner.nextLine();
        List<Shoe> oneShoe;
        while(true){
            System.out.println("Ange artikelnummer för beställning: ");
            String articleNr = scanner.nextLine().trim().toUpperCase();
            oneShoe = shoe.getOneShoeList(shoeList, articleNr);
            if (oneShoe.isEmpty()) {
                System.out.println("Fel artikelnummer, försök igen");
            } else {
                productID = shoe.getShoeID(oneShoe);
                break;
            }
        }
        repo.addToCart(customerID, orderID, productID);
        shoe.printShoes(oneShoe);
    }


    public static void main(String[] args) throws SQLException, IOException {


        ShoeStore orderMaker =  new ShoeStore();



    }
}
