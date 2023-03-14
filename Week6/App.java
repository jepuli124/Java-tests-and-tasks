package main;

import java.util.ArrayList;
import java.util.Scanner;

public class App{

    public static void main(String[] args){
        ArrayList<Gifu> vehicles = new ArrayList<Gifu>();
        String input = "s";
        String producer;
        String model;
        String maxSpeedS;
        int maxSpeed;
        Scanner scan = new Scanner(System.in);
        while(input != "e"){
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");
            if(scan.hasNext()){
                input = scan.nextLine();
                switch(input){
                    case "1":
                        System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
                        input = scan.nextLine();
                        switch(input){
                            case "1":
                                System.out.println("Anna kulkuneuvon valmistaja:");
                                producer = scan.nextLine();
                                System.out.println("Anna kulkuneuvon malli:");
                                model = scan.nextLine();
                                System.out.println("Anna kulkuneuvon huippunopeus:");
                                maxSpeedS = scan.nextLine();
                                maxSpeed = Integer.parseInt(maxSpeedS);
                                Car car = new Car(producer, model, maxSpeed);
                                vehicles.add(car);
                                break;
                            case "2":
                                System.out.println("Anna kulkuneuvon valmistaja:");
                                producer = scan.nextLine();
                                System.out.println("Anna kulkuneuvon malli:");
                                model = scan.nextLine();
                                System.out.println("Anna kulkuneuvon huippunopeus:");
                                maxSpeedS = scan.nextLine();
                                maxSpeed = Integer.parseInt(maxSpeedS);
                                Plane plane = new Plane(producer, model, maxSpeed);
                                vehicles.add(plane);
                                break;
                            case "3":
                                System.out.println("Anna kulkuneuvon valmistaja:");
                                producer = scan.nextLine();
                                System.out.println("Anna kulkuneuvon malli:");
                                model = scan.nextLine();
                                System.out.println("Anna kulkuneuvon huippunopeus:");
                                maxSpeedS = scan.nextLine();
                                maxSpeed = Integer.parseInt(maxSpeedS);
                                Student ship = new Student(producer, model, maxSpeed);
                                vehicles.add(ship);
                                break;
                            default:
                                System.out.println("Syöte oli väärä");
                                break;
                            }
                        break;
                    case "2":
                        for (Gifu vehicle : vehicles){
                            System.out.println(vehicle.getType() + ": "+ vehicle.getManufacturer() + " " + vehicle.getModel());
                            System.out.println("Moottori: " + vehicle.getNameEngine() + " " + vehicle.getPowerEngine()+ "kw");
                            System.out.println("Huippunopeus: "+vehicle.getMaxSpeed() + "km/h\n");
                        }
                        break;
                    case "3":
                        for (Gifu vehicle : vehicles){
                            if(vehicle instanceof Car){
                                Car car = (Car) vehicle;
                                car.drive();
                            }
                        }
                        break;
                    case "4":
                        for (Gifu vehicle : vehicles){
                            if(vehicle instanceof Plane){
                                Plane plane = (Plane) vehicle;
                                plane.fly();
                            }
                        }
                        break;
                    case "5":
                        for (Gifu vehicle : vehicles){
                            if(vehicle instanceof Student){
                                Student ship = (Student) vehicle;
                                ship.sail();
                            }
                        }
                        break;
                    case "0":
                        System.out.print("Kiitos ohjelman käytöstä.");
                        input = "e";
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;  
                    }
                }
        }
        scan.close();
    }
}