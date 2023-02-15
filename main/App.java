package main;
import java.util.Scanner; /* W3SCHOOl, löytyy vissiin kurssimateriaalistakin*/

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutput;
import java.lang.Character.UnicodeBlock;
import java.util.Collections; // W3Schools
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;



/* Konsta jalkanen, Wiikkotyö4, Versio: kyläl, Kehitys ympäristö = VSCODE  */




public class App implements Serializable {
    private static final long serialVersionUID = 242398L;
    public class Student implements Serializable{
         
        private static final long serialVersionUID = 24234298L;
        private String name;
        private int studentnumber;
        private ArrayList<Grade> grades = new ArrayList<Grade>();

        public Student(String name, int studentnumber){
            this.name = name;
            this.studentnumber = studentnumber;
        }

        public void addGrade(Grade grade){
            grades.add(grade);
        }

        public String getName(Student student){
            return student.name;
        }
    
        public int getNumber(Student student){
            return student.studentnumber;
        }
        public void printGrades(){
            for(Grade grade : grades){
                System.out.println(grade.getName(grade) + ": "+ grade.getGrade(grade));
            }
        }
        public ArrayList<Grade> getGrades(Student studie){
            return studie.grades;
        }

    }
    public class Grade implements Serializable{
        private static final long serialVersionUID = 95732453L;
        private String name;
        private int grade;

        public Grade(String name, int grade){
            this.name = name;
            this.grade = grade;
        }
        public String getName(Grade grade){
            return grade.name;
        }
        public int getGrade(Grade grade){
            return grade.grade;
        }
    }

    public class Calculator{
        public double getAverageGrade(int counter, University universal){
            int sum = 0;
            int counter2 = 0;
            Student readGrades= universal.getStudent(counter);
            ArrayList<Grade> grades = readGrades.getGrades(readGrades);
            for (Grade grade: grades){
                sum = sum + grade.grade;
                counter2 = counter2 + 1;
            }
            if (counter2 == 0){
                return 0;
            }
            return sum/counter2;

        }
        public double getMedianGrade(int counter, University universal){
            int sum = 0;
            double output = 0;
            Student readGrades= universal.getStudent(counter);
            ArrayList<Grade> grades = readGrades.getGrades(readGrades);
            ArrayList<Integer> iGrades = new ArrayList<Integer>(); // W3schools
            for (Grade grade: grades){
                iGrades.add(grade.grade);
            }
            if (iGrades.size() == 0){
                return 0;
            }
            Collections.sort(iGrades);
            int amount = iGrades.size();

            if (amount % 2 == 0){
                sum = iGrades.get(amount/2);
                output = iGrades.get((amount/2)-1);
                output = (output+sum)/2; 
            }
            else{
                output = iGrades.get(amount/2);
            }
            return output;
        }
    }

    public class University {
        final private String FILENAME;
        
        private ArrayList<Student> students = new ArrayList<Student>();
        public University(){
            FILENAME = "students.data";
        }

        public void addonestudent(Student student){
            students.add(student);
        }
        
        public void addstudents(ArrayList<Student> list){
            students.clear();
            for(Student one: list){
                students.add(one);
            }
            
        }
        public void readstudents(){
            for (Student student : students){
                System.out.println(student.getNumber(student) + ": " + student.getName(student));
            }
        }
        public void readstudentsorder(){
            int counter = 0;
            for (Student student : students){
                System.out.println(counter + ": " + student.getName(student));
                counter = counter + 1;
            }
        }
        public void gradeStudent(int counter, Grade grade){
            getStudent(counter).addGrade(grade);
            }
        public void getGradeStudent(int counter){
                getStudent(counter).printGrades();   
            }
        public Student getStudent(int counter){
            int counter2 = 0;
            for (Student student : students){
                if (counter == counter2){
                    return student;
                }
                counter2 = counter2 + 1;
            }
            Student studente = new Student("0", 0);
            return studente;
        }
        public void save(){
            try {
                FileOutputStream fileOut = new FileOutputStream(FILENAME);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(students);
                out.close();
                fileOut.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        public void load(){
            try {
                FileInputStream fileIn = new FileInputStream(FILENAME);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                students = (ArrayList<Student>) in.readObject();
                in.close();
                fileIn.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            
        }
    }  
        
    
    public static void main(String[] args){
        App h = new App();  // en tiedä miks mut korjaa asioita, Stackoverflow.
        String middleput = "s";
        Scanner input = new Scanner(System.in);
        Calculator calc = h.new Calculator();
        University universal = h.new University();

        while(middleput != "e"){
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            if (input.hasNext()){
                middleput = input.nextLine();
                switch(middleput){
                case "1":
                    System.out.println("Anna opiskelijan nimi?");
                    String name = input.nextLine();
                    System.out.println("Anna opiskelijan opiskelijanumero:");
                    String studentnumbers = input.nextLine();
                    int studentnumber = Integer.parseInt(studentnumbers);
                    Student student = h.new Student(name, studentnumber);
                    universal.addonestudent(student);
                    break;
                case "2":
                    System.out.println("Opiskelijat:");
                    universal.readstudents();
                    break;
                case "3":
                    universal.readstudentsorder();
                    System.out.println("Mille opiskelijalle suorite lisätään?");
                    String order = input.nextLine();
                    int iOrder = Integer.parseInt(order);
                    System.out.println("Mille kurssille suorite lisätään?");
                    String course =  input.nextLine();
                    System.out.println("Mikä arvosana kurssille lisätään?");
                    String grade =  input.nextLine();
                    int iGrade = Integer.parseInt(grade);

                    Grade newgrade = h.new Grade(course, iGrade);
                    universal.gradeStudent(iOrder, newgrade);

                    break;
                case "4":
                    universal.readstudentsorder();
                    System.out.println("Minkä opiskelijan suoritteet listataan?");
                    String order4 = input.nextLine();
                    int iOrder4 = Integer.parseInt(order4);
                    universal.getGradeStudent(iOrder4);

                    break;
                case "5":
                    universal.readstudentsorder();
                    System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                    String order5 = input.nextLine();
                    int iOrder5 = Integer.parseInt(order5);
                    System.out.println("Keskiarvo on " + calc.getAverageGrade(iOrder5, universal));

                    break;

                case "6":
                    universal.readstudentsorder();
                    System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                    String order6 = input.nextLine();
                    int iOrder6 = Integer.parseInt(order6);
                    System.out.println("Mediaani on " + calc.getMedianGrade(iOrder6, universal));

                    break;
                case "7":
                    universal.save();
                    break;
                case "8":
                    universal.load();
                    break;
                case "0":
                    System.out.println("Kiitos ohjelman käytöstä.");
                    middleput = "e";
                    break;
                default:
                    System.out.println("Syöte oli väärä");
                    break;

                }
            }
            
        }
        input.close();
        
    }
}
