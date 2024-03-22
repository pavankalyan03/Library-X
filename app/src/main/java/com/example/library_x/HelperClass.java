package com.example.library_x;

public class HelperClass {

    String username, email, password, books, dob;

    public HelperClass(String username, String email, String password, String books, String dob) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.books = books;
        this.dob = dob;
    }

    public HelperClass() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getDob() {
        return dob;
    }

    public void setBranch(String dob) {
        this.dob = dob;
    }
}
