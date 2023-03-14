package main;

public class Vehicle {
    protected String type;
    protected String manufacturer;
    protected String model;
    protected int maxSpeed;
    protected Course engine;


    public Vehicle(String type, String manufacturer, String model, int maxSpeed, String name, int power){
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.engine = new Course(name, power);

    }

    public String getType(){
        return this.type;
    }
    public String getManufacturer(){
        return this.manufacturer;
    }
    public String getModel(){
        return this.model;
    }
    public int getMaxSpeed(){
        return this.maxSpeed;
    }
    public String getNameEngine(){
        return this.engine.getName();
    }
    public int getPowerEngine(){
        return this.engine.getPower();
    }
}
