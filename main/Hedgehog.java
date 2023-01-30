package main;

public class Hedgehog {
    private String name;
    private int age;

    public Hedgehog() {
        name = "Pikseli";
        age = 5;
    }
// Keskusteltu tuomaksen kanssa kun hän katsoi opintovideot
    public Hedgehog(String name, int age){
        this.name = name;
        this.age = age;
    }

    static void speak(Hedgehog Hedge, String midput){  //Speaks
        
        if(midput.length() == 0){
            System.out.println("Olen "+ Hedge.name +" ja ikäni on "+ Hedge.age +" vuotta, mutta antaisitko silti syötteen?");
        }
        else {
            System.out.println(Hedge.name + ": " + midput);
        }
    
    }

    static void setNewHeegehoogeAge(Hedgehog Object, String name, int age){  //Change name and age
        Object.name = name;
        Object.age = age;
    }
    static void run(Hedgehog Object, int output){  // HedgeHog runs
        
        for(int counter = output; counter != 0; counter--){
            System.out.println(Object.name + " juoksee kovaa vauhtia!");
        }
    }

    
}
