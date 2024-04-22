package com.ps;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String checkedOutTo;
    private boolean isCheckedOut;

    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkedOutTo = "";
        this.isCheckedOut  = false;
    }

    public String getCheckedOutto() {
        return checkedOutTo;
    }

    public void setCheckedOutto(String checkedOutto) {
        this.checkedOutTo = checkedOutto;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void checkIn(String name){
        this.checkedOutTo = name;
    }

    public void checkOut(){

    }

    public void checkIn(){

    }
public String toString() {
        return "Book id: " + id + "  ISBN Number: " + isbn + "  Title: " + title;
}
}
