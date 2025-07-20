import java.util.Scanner;

// Kelas Node untuk menyimpan data pelanggan
class Node {
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }
}

// Kelas Queue menggunakan Linked List
class CustomerQueue {
    private Node head = null; // menunjuk ke pelanggan paling depan
    private Node tail = null; // menunjuk ke pelanggan paling belakang

    // Menambahkan pelanggan ke antrean
    public void enqueue(String name) {
        Node newNode = new Node(name);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Pelanggan " + name + " telah ditambahkan ke antrean.");
    }

    // Melayani pelanggan (menghapus dari depan antrean)
    public void serve() {
        if (head == null) {
            System.out.println("Tidak ada pelanggan dalam antrean.");
            return;
        }
        System.out.println("Melayani pelanggan: " + head.name);
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    // Menampilkan semua pelanggan dalam antrean
    public void displayQueue() {
        if (head == null) {
            System.out.println("Antrean kosong.");
            return;
        }

        System.out.println("Pelanggan dalam antrean:");
        Node current = head;
        int number = 1;
        while (current != null) {
            System.out.println(number + ". " + current.name);
            current = current.next;
            number++;
        }
    }
}

// Kelas utama
public class QueueSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerQueue queue = new CustomerQueue();
        int choice;

        do {
            System.out.println("\n=== Sistem Manajemen Antrean ===");
            System.out.println("1. Tambah pelanggan");
            System.out.println("2. Layani pelanggan");
            System.out.println("3. Tampilkan antrean");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Harap masukkan angka (1-4): ");
                scanner.next(); // buang input yang tidak valid
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // menghapus newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String name = scanner.nextLine();
                    queue.enqueue(name);
                    break;
                case 2:
                    queue.serve();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
