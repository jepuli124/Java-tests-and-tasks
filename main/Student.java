package main;

public class Student implements PrintInfo{
    private String name;
    private String number;

    public Student(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String getInformation(){
        return this.number + " " + this.name;
    }
}
