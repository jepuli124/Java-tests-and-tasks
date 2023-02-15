package main;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private ArrayList<Animal> animals = new ArrayList<Animal>(); //Checked from W3Schools

    public Zoo(String name){
        this.name = name;
    }   

    public void Addimal(Animal animal){
        animals.add(animal);
    }

    public void Listmal(){
        for (Animal animal : animals){
            System.out.println(animal.getSpecies(animal) + ": " + animal.getName(animal) + ", " + animal.getAge(animal) + " vuotta");
        }
    }

    public void run(int output){  // HedgeHog runs
        for (Animal animal : animals){
            for(int counter = output; counter != 0; counter--){
                System.out.println(animal.getName(animal) + " juoksee kovaa vauhtia!");
            }
        }
    }

    public String getName(Zoo zoo){
        return zoo.name;
    }

}
