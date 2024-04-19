package com.ps;

public class Book {
    private int id;
    private String isbn;
    private String title;

    public String getCheckedOutto() {
        return checkedOutto;
    }

    public void setCheckedOutto(String checkedOutto) {
        this.checkedOutto = checkedOutto;
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

    private boolean isCheckedOut;
    private String checkedOutto;

}
