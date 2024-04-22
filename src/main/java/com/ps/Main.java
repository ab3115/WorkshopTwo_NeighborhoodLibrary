package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

    Scanner scanner = new Scanner(System.in);
    Book[] Books = new Book[20];

    //Books in library inventory
    Books[0] = new Book(901, "PS 1017 .A1", "Pride and Prejudice");
    Books[1] = new Book(902, "PS 2384 .M6", "Moby Dick");
    Books[2] = new Book(903, "PS 3562 .E353", "To Kill a Mockingbird");
    Books[3] = new Book(904, "PR 6029 .R8", "1984");
    Books[4] = new Book(905, "PS 3511 .I9", "The Great Gatsby");
    Books[5] = new Book(906, "PR 4167 .J2", "Jane Eyre");
    Books[6] = new Book(907, "PS 3537 .A426", "The Catcher in the Rye");
    Books[7] = new Book(908, "PR 6039 .O32", "The Lord of the Rings");
    Books[8] = new Book(909, "PR 4172 .W8", "Wuthering Heights");
    Books[9] = new Book(910, "PG 3366 .A6", "Anna Karenina");
    Books[10] = new Book(911,"PR 5397 .F7", "Frankenstein");
    Books[11] = new Book(912,"PS 1305 .A1", "The Adventures of Huckleberry Finn");
    Books[12] = new Book(913,"PR 4560 .A1", "Great Expectations");
    Books[13] = new Book(914,"PR 5819 .A1", "The Picture of Dorian Gray");
    Books[14] = new Book(915,"PG 3366 .B6", "War and Peace");
    Books[15] = new Book(916,"PG 3326 .P7", "Crime and Punishment");
    Books[16] = new Book(917,"PS 1868 .A1", "The Scarlet Letter");
    Books[17] = new Book(918,"PR 6037 .T617", "Dracula");
    Books[18] = new Book(919,"PQ 2226 .A2", "The Count of Monte Cristo");
    Books[19] = new Book(920,"PQ 2286 .A2", "Les Misérables");



    int inputMainMenu;


    do   {

         System.out.println("Welcome! Please select which service you'd like to use:");
         System.out.println("\t(1) Show avaliable books");
         System.out.println("\t(2) Show checked out books");
         System.out.println("\t(3) Exit program");
         inputMainMenu = scanner.nextInt();

         switch(inputMainMenu) {
             case (1):
                 for (int i = 0; i < Books.length; i++) {
                     if (Books[i].isCheckedOut() == false) {
                         System.out.println(Books[i].toString());
                     }

                 }
                 int inputCheckOut;

                    do {
                        System.out.println("Would you like to checkout any of the available books?");
                        System.out.println("\t(1) Yes");
                        System.out.println("\t(2) No");
                        inputCheckOut = scanner.nextInt();
                        ;

                        switch(inputCheckOut) {
                            case(1):
                                System.out.println("Please select the name of the book you wish to check out!");
                                String title_checkingOut = scanner.nextLine();
                                scanner.nextLine();
                                System.out.println("Please enter your name to check out");
                                String name_checkingOut = scanner.nextLine();

                                for(int i = 0;i < Books.length; i++) {
                                if(Books[i].getTitle().equalsIgnoreCase(title_checkingOut)){
                                    Books[i].checkOut(name_checkingOut);



                                }



                                }


                                break;
                            case(2):
                                System.out.println("Exiting Selection");
                                break;
                            default:
                                System.out.println("Invalid input. Please enter 1 or 2.");
                                break;
                        }


                    } while(inputCheckOut != 2);
                 break;

             case (2):

                 for (int i = 0; i < Books.length; i++) {
                     if (Books[i].isCheckedOut() == true) {
                         System.out.println(Books[i].toString() + Books[i].getCheckedOutto());
                     }
                     else{
                         System.out.print("No checked out books");
                     }
                 }
                 String input_checkIn;
                 do {

                     System.out.println("Would you like to:");
                     System.out.println("\t(C)heck in a book");
                     System.out.println("\t(X)-it program");
                     input_checkIn = scanner.nextLine();
                     scanner.nextLine();

                     switch(input_checkIn) {
                         case "C":

                             System.out.println("Please enter the id of the book you're checking in");
                             int id_checkIn = scanner.nextInt();

                         for (int i = 0; i < Books.length; i++) {
                             if (Books[i].getId() == id_checkIn){
                                 Books[i].checkIn();
                             }
                         }
                        break;

                         case "X":
                             System.out.println("Returning to Main Menu");
                             break;
                     }


                 }while(!input_checkIn.equals("X"));

                 break;
             case (3):
                 System.out.println("Ending Program");
                 break;
             default:
                 System.out.println("Invalid input. Please enter 1, 2, or 3.");
                 break;
         }








    }while(inputMainMenu != 3);

       }

}
