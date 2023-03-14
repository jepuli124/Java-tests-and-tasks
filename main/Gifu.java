package main;

import java.util.ArrayList;

public class Gifu {
    private String university;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
    

    public Gifu(String university){
       this.university = university;
    }

    public void addCourse(Course course){
        this.courses.add(course);
        return;
    }

    public Course getCourse(int id){
        return this.courses.get(id);
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public void listCourses(){
        int counter = 0;
        for (Course course: this.courses){
            System.out.println(counter + ") " + course.getInformation());
            counter = counter + 1;
        }
        return;
    }

    public void addStudent(Student student){
        this.students.add(student);
        return;
    }

    public Student getStudent(int id){
        return this.students.get(id);
    }

    public void listStudents(){
        int counter = 0;
        for (Student student: this.students){
            System.out.println(counter + ") " + student.getInformation());
            counter = counter + 1;
        }
        return;
    }

    public void enrollStudent(Student student, Course course){
        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
        return;
    }

    public ArrayList<Enrollment> getEnrollments(Course course){
        ArrayList<Enrollment> returnableEnrollments= new ArrayList<Enrollment>();
        for (Enrollment enrollment: this.enrollments){
            if (course == enrollment.getCourse()){
                returnableEnrollments.add(enrollment);
            }
        }
        return returnableEnrollments;
    }

    public ArrayList<Enrollment> getEnrollments(Student student){
        ArrayList<Enrollment> returnableEnrollmets= new ArrayList<Enrollment>();
        for (Enrollment enrollment: this.enrollments){
            if (student == enrollment.getStudent()){
                returnableEnrollmets.add(enrollment);
            }
        }
        return returnableEnrollmets;
    }
}
