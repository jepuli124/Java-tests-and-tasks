package main;
import java.util.Scanner; /* W3SCHOOl, löytyy vissiin kurssimateriaalistakin*/

import javax.sql.rowset.CachedRowSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/* Konsta jalkanen, Wiikkotyö, Versio: kyläl, Kehitys ympäristö = VSCODE  */




public class App {
    public static void main(String[] args){
        String middleput = "s";
        System.out.println("Anna eläintarhalle nimi:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        Zoo zoo = new Zoo(name);
        while(middleput != "e"){
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");
            if (input.hasNext()){
                middleput = input.nextLine();
                switch(middleput){
                case "1":
                    System.out.println("Mikä laji?");
                    String species = input.nextLine();
                    System.out.println("Anna eläimen nimi:");
                    name = input.nextLine();
                    System.out.println("Anna eläimen ikä:");
                    String level = input.nextLine();
                    int age = Integer.parseInt(level);
                    Animal animal = new Animal(name, age, species);
                    zoo.Addimal(animal);
                    break;
                case "2":
                    System.out.println(zoo.getName(zoo) + " pitää sisällään seuraavat eläimet:");
                    zoo.Listmal();
                    break;
                case "3":
                    System.out.println("Kuinka monta kierrosta?");
                    String amount = input.nextLine();
                    int run = Integer.parseInt(amount);
                    zoo.run(run);
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