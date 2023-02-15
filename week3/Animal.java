package main;



public class Animal {
    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species){
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName(Animal animal){
        return animal.name;
    }

    public int getAge(Animal animal){
        return animal.age;
    }

    public String getSpecies(Animal animal){
        return animal.species;
    }
}