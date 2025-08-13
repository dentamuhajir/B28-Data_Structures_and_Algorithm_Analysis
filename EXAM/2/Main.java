

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

    // void insertAfter() {

    // }

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
        // 43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25

        // Insert Linked list
        for(int number: data) {
            singleLinkedList.add(number);    
        }
        singleLinkedList.printAll();       
    }

}
