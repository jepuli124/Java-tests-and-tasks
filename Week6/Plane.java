package main;

public class Plane extends Gifu{
    public Plane(String manufacturer, String model, int maxSpeed){
        super("Lentokone", manufacturer, model, maxSpeed, "Suihkumoottori", 500);
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void fly(){
        System.out.println(this.manufacturer + " " + this.model + " lentää kohteeseen!");
    }

}
