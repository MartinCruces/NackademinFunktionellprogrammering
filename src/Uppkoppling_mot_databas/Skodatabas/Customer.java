package Uppkoppling_mot_databas.Skodatabas;

import java.util.List;
import java.util.Scanner;

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String areaCode;
    private String city;
    private String passWord;

    Customer(){}

    public Customer(int id, String firstName, String lastName, String address,
                    String areaCode, String city, String passWord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.areaCode = areaCode;
        this.city = city;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Customer> confirmCustomer(List<Customer> customerList, String firstName, String passWord){

        return customerList.stream().filter(customer -> customer.getFirstName().equalsIgnoreCase(firstName)).
                filter(customer -> customer.getPassWord().equalsIgnoreCase(passWord)).toList();
    }
    public int getCustomerID(List<Customer> list){
        return list.stream().mapToInt(customer -> customer.getId()).findAny().getAsInt();
    }
    public void printOneCustomer(List<Customer> list, int customerID){
        list.stream().filter(customer -> customer.getId()== customerID).forEach(customer -> System.out.println(
                customer.getFirstName() + " " + customer.getLastName()));
    }
    public int getCustomerLoginId(List<Customer> customerList){

        while(true) {
            System.out.println("För att logga in skriv ditt förnamn:");
            Scanner scanner = new Scanner(System.in);
            String firstName = scanner.nextLine().trim();
            System.out.println("Skriv in ditt lösenord");
            String passWord = scanner.nextLine().trim();
            List<Customer> temp = confirmCustomer(customerList, firstName, passWord);
            if (temp.isEmpty()) {
                System.out.println("Namn eller lösenord är fel");
            } else {
                int customerID = getCustomerID(temp);
                return customerID;
            }
        }

    }
}
