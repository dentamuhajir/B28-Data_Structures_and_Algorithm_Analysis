class Inventory {
    // Deklarasi properti
    private String name;
    private int amountStock;
    private double price;

    // Constructor untuk assign data properti dengan parameter di method contructor
    public Inventory(String name, int amountStock, int price) {
        this.name = name;
        this.amountStock = amountStock;
        this.price = price;
    }

    // Penambahan getter untuk mengambil data properti private
    public String getName() {
        return name;
    }

    public int getAmountStock() {
        return amountStock;
    }

    public double getPrice() {
        return price;
    }

    // menambahakan static method agar bisa diakses langsung
    // Membutuhkan parameter array objek inventoy untuk ditampilkan diperulangan
    public static void getInventories(Inventory[] inventories) {
        System.out.println("Inventaris Toko");
        for(int i = 0; i < inventories.length; i++) {
            // kondisional untuk menghindari error karena total array 10 hanya memasukan 5 data
            if(inventories[i] != null) {
                System.out.println(i + 1 + ". " + "Nama: " + inventories[i].getName() + ", Jumlah Stok: " + inventories[i].getAmountStock() + ", Harga: " + inventories[i].getPrice());
            }
        }
    }
}

public class main {
    public static void main(String[] args) {
        // Deklarasi objek array inventory dengan total data 10 array
        Inventory[] inventories = new Inventory[10];

        // Assign data di parameter constructor. contoh ini saya assign 5 data
        inventories[0] = new Inventory("Pensil", 5, 4000);
        inventories[1] = new Inventory("Buku", 4, 5000);
        inventories[2] = new Inventory("Printer", 4, 5000000);
        inventories[3] = new Inventory("Kursi", 5, 1000000);
        inventories[4] = new Inventory("Jam Dinding", 6, 100000);
        

        // Pemanggilan method static tanpa perlu insialisasi dan assign data Array inventories
        Inventory.getInventories(inventories);
    }
}
