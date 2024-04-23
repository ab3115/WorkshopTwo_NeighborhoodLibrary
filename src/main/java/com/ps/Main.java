package com.ps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
        Books[10] = new Book(911, "PR 5397 .F7", "Frankenstein");
        Books[11] = new Book(912, "PS 1305 .A1", "The Adventures of Huckleberry Finn");
        Books[12] = new Book(913, "PR 4560 .A1", "Great Expectations");
        Books[13] = new Book(914, "PR 5819 .A1", "The Picture of Dorian Gray");
        Books[14] = new Book(915, "PG 3366 .B6", "War and Peace");
        Books[15] = new Book(916, "PG 3326 .P7", "Crime and Punishment");
        Books[16] = new Book(917, "PS 1868 .A1", "The Scarlet Letter");
        Books[17] = new Book(918, "PR 6037 .T617", "Dracula");
        Books[18] = new Book(919, "PQ 2226 .A2", "The Count of Monte Cristo");
        Books[19] = new Book(920, "PQ 2286 .A2", "Les Misérables");


        int inputMainMenu;

        do {

            System.out.println("Welcome to the Neighborhood Library! Please select which service you'd like to use:");
            System.out.println("\t(1) Show avaliable books");
            System.out.println("\t(2) Show checked out books");
            System.out.println("\t(3) Exit program");
            inputMainMenu = scanner.nextInt();
            scanner.nextLine();

            switch (inputMainMenu) {
                case (1):

                    menuDisplayAvaliable(Books);
                        int inputCheckOut;

                        do {
                            System.out.println("Would you like to checkout any of the available books?");
                            System.out.println("\t(1) Yes");
                            System.out.println("\t(2) No");
                            inputCheckOut = scanner.nextInt();
                            scanner.nextLine();


                            switch (inputCheckOut) {

                                case (1):

                                    System.out.println("Please select the name of the book you wish to check out!");
                                    String title_checkingOut = scanner.nextLine();
                                    System.out.println("Please enter your name to check out");
                                    String name_checkingOut = scanner.nextLine();
                                    menuCheckOut(Books, title_checkingOut, name_checkingOut);
                                    break;


                                case (2):

                                    System.out.println("Exiting selection...");
                                    break;

                                default:
                                    System.out.println("Invalid input. Please select choice 1 or 2.");
                                    break;
                            }


                        } while (inputCheckOut != 2);
                        break;

                        case (2):

                            menuCheckedOutTo(Books);
                            String input_checkIn;
                            do {

                                System.out.println("Would you like to:");
                                System.out.println("\t(C)heck in a book");
                                System.out.println("\t(X) Exit program");
                                input_checkIn = scanner.nextLine();
                                scanner.nextLine();
                                scanner.nextLine();

                                switch (input_checkIn) {
                                    case "C":

                                        System.out.println("Please enter the id of the book you're checking in");
                                        int id_checkIn = scanner.nextInt();
                                        scanner.nextLine();
                                        scanner.nextLine();

                                       menuCheckIn(Books, id_checkIn);

                                        break;

                                    case "X":
                                        System.out.println("Returning to Main Menu");
                                        break;

                                    default:
                                        System.out.println("Invalid input. Please enter C or X.");
                                        break;
                                }
                            } while (!input_checkIn.equals("X"));
                            break;


                        case (3):
                            System.out.println("Ending Program");
                            break;
                        default:
                            System.out.println("Invalid input. Please enter 1, 2, or 3.");
                            break;

                    }

            }

            while (inputMainMenu != 3) ;

    }


    public static void menuDisplayAvaliable(Book[] Books) {

        for (int i = 0; i < Books.length; i++) {

            if (Books[i].isCheckedOut() == false) {
                System.out.println(Books[i].toString());

            }
        }
        //New line for nicer appearance
        System.out.println();
    }


    public static void menuCheckedOutTo(Book[] Books){

        boolean books_are_checkedOut = false;
        System.out.println("Books Checked Out:");
        for (int i = 0; i < Books.length; i++) {

            if (Books[i].isCheckedOut() == true) {
                System.out.println(Books[i].toString() +" Checked out to: " + Books[i].getCheckedOutto());
                books_are_checkedOut = true;
            }
        }

        if(books_are_checkedOut == true){
    System.out.println("There are currently a total of " + Book.getNumBooksCheckedOut() + " book(s) checked out.");
        System.out.println((20 - Book.getNumBooksCheckedOut()) + " book(s) are still available for checkout from our collection.");
        }else{
            System.out.println("There are currently no books checked out.");
        }

    }



    public static void menuCheckIn(Book[] Books, int id_checkIn){

        boolean valid_id = false;
        for (int i = 0; i < Books.length; i++) {

            if (Books[i].getId() == id_checkIn) {
                Books[i].checkIn();
                valid_id = true;
                System.out.println(Books[i].getTitle() + " was successfully checked in. Thank You!");
            }

        }
        if(valid_id == false){
            System.out.println("The id you entered was not found");
        }
    }


    public static void menuCheckOut(Book[] Books, String title_checkingOut, String name_checkingOut) {

        boolean matching_title_confirm = false;
        boolean checked_out_confirm = false;
         for (int i = 0; i < Books.length; i++) {

            if (Books[i].getTitle().equalsIgnoreCase(title_checkingOut)) {
                if (!Books[i].isCheckedOut()) {
                    Books[i].checkOut(name_checkingOut);
                    checked_out_confirm = true;
                    System.out.println(Books[i].getTitle() + " is now checked out to: " + Books[i].getCheckedOutto());
                }else{
                    System.out.println(Books[i].getTitle() + " is currently checked out, please select another title");
                    matching_title_confirm = true;
                }
            }

         }
         if(!checked_out_confirm && !matching_title_confirm){
             System.out.println("Unfortunately " + title_checkingOut + " was not found, please enter a valid title from our selection.");
         }

    }




}
