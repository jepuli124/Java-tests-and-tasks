package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App{

    public static void main(String[] args){
        String input = "s";
        String name;
        String id;
        int amount;
        int amount2;
        Scanner scan = new Scanner(System.in);
        System.out.println("Tervetuloa Gifu-järjestelmään");
        System.out.println("Mille yliopistolle haluat ottaa järjestelmän käyttöön?");
        input = scan.nextLine();
        Gifu g = new Gifu(input);

        while(input != "e"){
            System.out.println("1) Luo uusi kurssi, 2) Luo uusi opiskelija, 3) Listaa kurssit, 4) Listaa opiskelijat, 5) Lisää opiskelija kurssille, 6) Anna kurssiarvosanat, 7) Listaa kurssilla olevat opiskelijat, 8) Listaa opiskelijan arvosanat, 9) Listaa kaikkien kurssien kaikkien opiskelijoiden arvosanat, 0) Lopeta ohjelma");
            if(scan.hasNext()){
                input = scan.nextLine();
                switch(input){
                    case "1":
                        System.out.println("Anna kurssin nimi:");
                        name = scan.nextLine();
                        System.out.println("Anna kurssin ID:");
                        id = scan.nextLine();
                        System.out.println("Anna kurssin maksimi opiskelijamäärä:");
                        input = scan.nextLine();
                        amount = Integer.parseInt(input);
                        Course course = new Course(name, id, amount);
                        g.addCourse(course);
                        break;
                    case "2":
                        System.out.println("Anna opiskelijan nimi:");
                        name = scan.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        input = scan.nextLine();
                        Student student = new Student(name, input);
                        g.addStudent(student);
                        break;
                    case "3":
                        g.listCourses();
                        break;
                    case "4":
                        g.listStudents();
                        break;
                    case "5":
                        g.listCourses();
                        System.out.println("Mille kurssille haluat lisätä opiskelijan? Syötä kurssin numero:");
                        input = scan.nextLine();
                        amount = Integer.parseInt(input);
                        g.listStudents();
                        System.out.println("Minkä opiskelijan haluat lisätä kurssille? Syötä opiskelijan numero:");
                        input = scan.nextLine();
                        amount2 = Integer.parseInt(input);
                        g.enrollStudent(g.getStudent(amount2), g.getCourse(amount));
                        break;
                    case "6":
                        g.listCourses();
                        System.out.println("Minkä kurssin haluat arvostella? Syötä kurssin numero:");
                        input = scan.nextLine();
                        amount = Integer.parseInt(input);
                        for (Enrollment enrollment : g.getEnrollments(g.getCourse(amount))){
                            System.out.println("Anna arvosana opiskelijalle " + enrollment.getStudent().getInformation());
                            input = scan.nextLine();
                            amount2 = Integer.parseInt(input);
                            enrollment.gradeCourse(amount2);
                        }

                        break;
                    case "7":
                        g.listCourses();
                        System.out.println("Minkä kurssin opiskelijat haluat listata? Syötä kurssin numero:");
                        input = scan.nextLine();
                        amount = Integer.parseInt(input);
                        for (Enrollment enrollment : g.getEnrollments(g.getCourse(amount))){
                            System.out.println(enrollment.getStudent().getInformation() + ", arvosana: " + enrollment.getGrade());
                        }
                        break;
                    case "8":
                        g.listStudents();
                        System.out.println("Minkä opiskelijan arvosanat haluat listata? Syötä opiskelijan numero:");
                        input = scan.nextLine();
                        amount = Integer.parseInt(input);
                        System.out.println("Opiskelijan " + g.getStudent(amount).getInformation() +" arvosanat:");
                        for (Enrollment enrollment : g.getEnrollments(g.getStudent(amount))){
                            System.out.println(enrollment.getCourse().getInformation()+ ", arvosana: " + enrollment.getGrade());
                        }
                        break;
                    case "9":
                        for (Course courseL: g.getCourses()){
                            System.out.println(courseL.getInformation());
                            for (Enrollment enrollment2 : g.getEnrollments(courseL)){
                                System.out.println(enrollment2.getStudent().getInformation() + ", arvosana: " + enrollment2.getGrade());
                            }
                        }
                        break;
                    case "0":
                        System.out.print("Kiitos ohjelman käytöstä.");
                        input = "e";
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;  
                    }
                }
        }
        scan.close();
    }
}
