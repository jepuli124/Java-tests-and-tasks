package main;

public class Ship extends Gifu{
    public Ship(String manufacturer, String model, int maxSpeed){
        super("Laiva", manufacturer, model, maxSpeed, "Wärtsilä Super", 1000);
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void sail(){
        System.out.println(this.manufacturer + " " + this.model + " seilaa merten ääriin!");
    }
}
