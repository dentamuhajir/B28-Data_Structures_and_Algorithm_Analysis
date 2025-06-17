class University {
    private String name;
    private String address;

    public University(String name,String address){
        this.name =  name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void showInfo() {
        System.out.println("Univerity name :" + getName());
        System.out.println("University address:" + getAddress());
    }
}

public class main {
    public static void main(String[] args) {
        University university = new University("Binus", "West JakartA");
        university.showInfo();    
    }
}
