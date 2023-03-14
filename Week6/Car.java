package main;

public class Car extends Gifu{
    public Car(String manufacturer, String model, int maxSpeed){
        super("Auto", manufacturer, model, maxSpeed, "V8", 300);
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;

    }

    public void drive(){
        System.out.println(this.manufacturer + " " + this.model + " paahtaa tietä eteenpäin!");
    }
}
