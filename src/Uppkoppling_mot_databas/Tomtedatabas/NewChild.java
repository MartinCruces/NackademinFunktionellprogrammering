package Uppkoppling_mot_databas.Tomtedatabas;

import java.util.Scanner;

public class NewChild {

    public NewChild (){
        Repository r = new Repository();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in namn");
        String name = scanner.nextLine();
        System.out.println("Skriv in adress");
        String adress = scanner.nextLine();
        System.out.println("Skriv in land ID");
        int countryId = scanner.nextInt();
        System.out.println("Skriv in \"true\" för snäll och \"false\" för stygg");
        boolean nice = scanner.hasNextBoolean();

        r.insertChild(name, adress, countryId, nice);




        System.out.println("Barn inskrivet:");
        r.getChildByName(name).printOut();


    }

    public static void main(String[] args) {

        NewChild insert = new NewChild();

    }
}
