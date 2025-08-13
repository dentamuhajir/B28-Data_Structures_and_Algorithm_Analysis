

class SinglyNode {
    int data;             // Menyimpan data dari node
    SinglyNode next;      // Referensi ke node berikutnya (null kalau ini node terakhir)

    SinglyNode(int data) {
        this.data = data; // Konstruktor: mengisi nilai data
    }
}

class Process{
    SinglyNode head;

    void add(int data) {
        SinglyNode newNode = new SinglyNode(data); // Buat simpul baru

        if (head == null) {     // Kalau kosong, node pertama langsung jadi head
            head = newNode;
            return;
        }

        SinglyNode current = head; // Mulai dari head
        while (current.next != null) { // Ulangi sampai node terakhir
            current = current.next;
        }
        current.next = newNode; // Hubungkan node terakhir ke node baru
    }

    void addAll(int[] data) {


        for (int number: data) {
            SinglyNode newNode = new SinglyNode(number); 

            if (head == null) {     
                head = newNode;
                return;
            }

            SinglyNode current = head; 
            while (current.next != null) { 
                current = current.next;
            }
            current.next = newNode;
            
        }

        // SinglyNode newNode = new SinglyNode(data); 

        // if (head == null) {     
        //     head = newNode;
        //     return;
        // }

        // SinglyNode current = head; 
        // while (current.next != null) { 
        //     current = current.next;
        // }
        // current.next = newNode;
    }

    // Sisipkan setelah nilai tertentu
    void insertAfter(int target, int newData) {
        SinglyNode current = head;

        // Cari node dengan data == target
        while (current != null && current.data != target) {
            current = current.next;
        }

        // Jika target tidak ditemukan
        if (current == null) {
            System.out.println("Node dengan nilai " + target + " tidak ditemukan.");
            return;
        }

        // Buat node baru dan sisipkan
        SinglyNode newNode = new SinglyNode(newData);
        newNode.next = current.next;
        current.next = newNode;
    }

    // Hapus node berdasarkan nilai
    void delete(int target) {
        // Jika list kosong
        if (head == null) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        // Jika node yang dihapus adalah head
        if (head.data == target) {
            head = head.next;
            System.out.println("Node dengan nilai " + target + " dihapus.");
            return;
        }

        // Cari node sebelumnya
        SinglyNode current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }

        // Jika tidak ditemukan
        if (current.next == null) {
            System.out.println("Node dengan nilai " + target + " tidak ditemukan.");
            return;
        }

        // Hapus node dengan melewati referensinya
        current.next = current.next.next;
        System.out.println("Node dengan nilai " + target + " dihapus.");
    }

    void printAll() {
        SinglyNode current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");

    }

}

public class Main {

    public static void main(String[] args) {
        Process singleLinkedList = new Process();
        int[] data = {43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25}; 
        // Insert Linked list
        for(int number: data) {
            singleLinkedList.add(number);    
        }
        singleLinkedList.printAll();    
        
        singleLinkedList.insertAfter(24, 60);

        singleLinkedList.printAll();

        singleLinkedList.delete(35);

        singleLinkedList.printAll();
    }

}
