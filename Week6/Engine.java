package main;

public class Engine {
    private String name;
    private int power;


    public Engine(String name, int power){
        this.name = name;
        this.power = power;

    }

    public String getName(){
        return this.name;
    }

    public int getPower(){
        return this.power;
    }

}
