package main;
import java.util.Scanner; /* W3SCHOOl, löytyy vissiin kurssimateriaalistakin*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* Konsta jalkanen, Wiikkotyö, Versio: kyläl, Kehitys ympäristö = VSCODE  */


/*Lähde: Katsoin luennot*/



/* Funktiot ja toiminnot katsottu W3School:lista. Muu toteuttettu itse. */

public class App {
    
    
    /*
    static String NewHeegehooge(){
        System.out.println("Anna siilin nimi: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        input.close();

        return name;
    }
    static int NewHeegehoogeAge(){
        System.out.println("Anna siilin ikä: ");
        Scanner input2 = new Scanner(System.in);
        int age = input2.nextInt();
        input2.close();

        return age;
    }
    */






    public static void main(String[] args){
        String middleput = "s";
        Hedgehog hedge = new Hedgehog(); 
        Scanner input = new Scanner(System.in);
        while(middleput != "e"){
            System.out.println("1) Pistä siili puhumaan, 2) Luo uusi siili, 3) Juoksuta siiliä, 0) Lopeta ohjelma");
            if (input.hasNext()){
                String parse = input.nextLine();
                int maddleput = Integer.parseInt(parse);
                if(maddleput == 1){
                    System.out.println("Mitä siili sanoo: ");
                    String midput = input.nextLine();
                    Hedgehog.speak(hedge, midput);
                }
                else if(maddleput == 2){
                    System.out.println("Anna siilin nimi:");
                    String name = input.nextLine();
                    System.out.println("Anna siilin ikä:");
                    String parse2 = input.nextLine();
                    int age = Integer.parseInt(parse2);
                    Hedgehog.setNewHeegehoogeAge(hedge, name, age); 
                    }
                else if(maddleput == 3){
                    System.out.println("Kuinka monta kierrosta?");
                    String parse3 = input.nextLine();
                    int output = Integer.parseInt(parse3);
                    Hedgehog.run(hedge, output);
                }
                else if(maddleput == 0){
                    System.out.println("Kiitos ohjelman käytöstä.");
                    middleput = "e";
                }
                else{
                    System.out.println("Syöte oli väärä");
                }
            }
        }
        input.close();
    }
}
