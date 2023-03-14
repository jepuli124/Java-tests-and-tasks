package main;

public class Course implements PrintInfo{
    int maxNumberOfStudents;
    String name;
    String id;
    public Course(String name, String id,int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.name = name;
        this.id = id;
    }

    public String getInformation(){
        return this.id + " " + this.name;
    }
}
