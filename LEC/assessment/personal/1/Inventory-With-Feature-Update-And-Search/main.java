import java.util.Scanner;

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

    // Penambahan setter & getter untuk assign value dan get data properti private

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountStock(int amountStock) {
        this.amountStock = amountStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmountStock() {
        return amountStock;
    }

    public double getPrice() {
        return price;
    }

    // penambahan static method agar method ini bisa diakses langsung tanpa inisialisasi
    // membutuhkan 2 paremeter yaitu title untuk dan array object innventory
    public static void getInventories(String title, Inventory[] inventories) {
        System.out.println("--------------------------------------------------------");
        System.out.println(title);
        for(int i = 0; i < inventories.length; i++) {
            System.out.println(i + 1 + ". " + "Nama: " + inventories[i].getName() + ", Stok: " + inventories[i].getAmountStock() + ", Harga: " + inventories[i].getPrice());
        }
        System.out.println("--------------------------------------------------------");
    }


    // method untuk update stok inventoris berdasarkan nama , membutuhkan parameter name, stok baru dan objeck array inventories
    public static Boolean updateStock(String name, int newStock, Inventory[] inventories) {
        String status = "(info) Data tidak ditemukan";
        Boolean update = false;
        for(int i = 0; i < inventories.length; i++) {
            // Jika Data list array cocok dengan input param nama update status wording dan update menjadi true
            if(inventories[i].getName().equals(name)) {
                inventories[i].setAmountStock(newStock);
                status = "(info) Berhasil Update stok produk " + inventories[i].getName();
                update = true;
            }
        }

        System.out.println(status);
        return update;
    }

    // Method search untuk fungsi pencarian data inventoris berdasarkan nama membutuhkan parameter nama dan Array Objeck Inventory
    public static void search(String name, Inventory[] inventories) {
        String result = "(info) Data tidak ditemukan";
        for(int i = 0; i < inventories.length; i++) {
            // menggunakan contain agar ketika nama ada di dalam list array maka dapat match tanpa harus benar2 equal datanya
            if(inventories[i].getName().contains(name)) {
                result = "Nama: " + inventories[i].getName() + ", Stok: " + inventories[i].getAmountStock() + ", Harga: " + inventories[i].getPrice();
            }
        }
        System.out.println("Hasil Pencarian:");
        System.out.println(result);
    }

}
public class main {
    public static void main(String[] args) {
        Inventory[] inventories = new Inventory[3];
        inventories[0] = new Inventory("pensil", 3, 2000000);
        inventories[1] = new Inventory("buku", 2, 890000);
        inventories[2] = new Inventory("komputer", 2, 250000);

        Inventory.getInventories("Inventaris Toko", inventories);


        // Library untuk input data
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama barang yang ingin diupdate: ");
        String updateName = scanner.nextLine();
        System.out.print("Masukkan jumlah stok baru: ");
        int newStock = scanner.nextInt();
        scanner.nextLine(); 

        Boolean update = Inventory.updateStock(updateName, newStock, inventories);

        // Jika callback dari method updateStock true maka tampilkan list inventory
        if(update) {
            Inventory.getInventories("Inventaris setelah diupdate" ,inventories);
        }
    
        System.out.print("Masukkan nama barang yang dicari: ");
        String searchName = scanner.nextLine();
        Inventory.search(searchName, inventories);

        scanner.close();

    }    
}
