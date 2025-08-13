class Vehicle {
    private String name;
    private String merch;

    public Vehicle(String name, String merch) {
        this.name = name;
        this.merch = merch;
    }

    public String getName() {
        return name;
    }

    public String getMerch() {
        return merch;
    }

    // Default implementation (can be overridden)
    public void vehicleInformation() {
        System.out.println("Generic vehicle: " + name + " by " + merch);
    }
}

class Car extends Vehicle {
    private Boolean isElectric;
    private String mode; // e.g., Sport, Eco, Comfort

    public Car(String name, String merch, Boolean isElectric, String mode) {
        super(name, merch);
        this.isElectric = isElectric;
        this.mode = mode;
    }

    @Override
    public void vehicleInformation() {
        System.out.println("Car: " + getName() + " by " + getMerch());
        System.out.println("Electric: " + (isElectric ? "Yes" : "No"));
        System.out.println("Drive Mode: " + mode);
    }
}

class Motorcycle extends Vehicle {
    private int engineCapacity; // in CC

    public Motorcycle(String name, String merch, int engineCapacity) {
        super(name, merch);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void vehicleInformation() {
        System.out.println("Motorcycle: " + getName() + " by " + getMerch());
        System.out.println("Engine Capacity: " + engineCapacity + " cc");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("L300", "Toyota", true, "Sport");
        Vehicle bike = new Motorcycle("Ninja ZX-6R", "Kawasaki", 636);

        // Polymorphism: array of different vehicle types
        Vehicle[] vehicles = {car, bike};

        for (Vehicle v : vehicles) {
            v.vehicleInformation();
            System.out.println();
        }
    }
}
