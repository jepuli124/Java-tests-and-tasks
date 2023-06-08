package com.example.week9;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String firstname;
    private String lastname;
    private String email;
    private String degreeProgram;

    private ArrayList<String> degrees = new ArrayList<>();

    private static final long serialVersionUID = 2398L;

    private int image;

    public User(String firstname, String lastname, String email, String degreeProgram, int image, ArrayList<String> degrees){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.image = image;
        this.degrees = degrees;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<String> getDegrees() {
        return degrees;
    }
}
