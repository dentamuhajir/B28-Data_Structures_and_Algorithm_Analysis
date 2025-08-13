class Vehicle {
    private String name;
    private String merch;

    public Vehicle(String name, String merch) {
        this.name = name;
        this.merch = merch;
    }
    
    
    public static void main(String[] args) {

        Car car = new Car("L300", "toyota", true);
        car.vehicleInformation();
        
    }

    public void vehicleInformation(){
        
    }

}

class Car extends Vehicle{
    private Boolean isElectric;
    
    public Car(String name, String merch, Boolean isElectric) {
        super(name, merch);
        this.isElectric = isElectric;
    }

    public void vehicleInformation() {

        System.out.println("This is information from Car");


    }


}

class Motorcycle extends Vehicle{


    public Motorcycle(String name, String merch) {
        super(name, merch);
        
    }
    
    public void vehicleInformation() {
        System.out.println("This is information from Motorcycle");
    }

}