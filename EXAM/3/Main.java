class DoublyNode {
    int data;
    DoublyNode next; // Pointer ke node berikutnya
    DoublyNode prev; // Pointer ke node sebelumnya

    DoublyNode(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail; // Simpan tail untuk efisiensi

    // Tambah node di akhir
    void add(int data) {
        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Tambah semua data
    void addAll(int[] data) {
        for (int number : data) {
            add(number);
        }
    }

    // Sisipkan setelah nilai tertentu
    void insertAfter(int target, int newData) {
        DoublyNode current = head;

        while (current != null && current.data != target) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan nilai " + target + " tidak ditemukan.");
            return;
        }

        DoublyNode newNode = new DoublyNode(newData);
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode; // Update tail jika di akhir
        }

        current.next = newNode;
    }

    // Hapus node berdasarkan nilai
    void delete(int target) {
        if (head == null) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        DoublyNode current = head;

        while (current != null && current.data != target) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan nilai " + target + " tidak ditemukan.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Menghapus head
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Menghapus tail
        }

        System.out.println("Node dengan nilai " + target + " dihapus.");
    }

    // Cetak dari head ke tail
    void printForward() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " ↔ ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Cetak dari tail ke head
    void printBackward() {
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current.data + " ↔ ");
            current = current.prev;
        }
        System.out.println("null");
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        int[] data = {43, 5, 9, 42, 6, 11, 41, 7, 13, 100, 12, 70, 24, 40, 36, 16, 35, 14, 30, 25}; 

        dll.addAll(data);

        System.out.println("Sebelum operasi:");
        dll.printForward();

        dll.insertAfter(24, 60);
        System.out.println("\nSetelah insertAfter 24:");
        dll.printForward();

        dll.delete(35);
        System.out.println("\nSetelah delete 35:");
        dll.printForward();

        System.out.println("\nCetak mundur:");
        dll.printBackward();
    }
}
