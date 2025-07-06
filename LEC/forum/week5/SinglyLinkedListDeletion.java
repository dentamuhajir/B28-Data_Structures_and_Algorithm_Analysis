public class SinglyLinkedListDeletion {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked List head
    Node head;

    // Insert node di akhir untuk kebutuhan testing
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete node di awal (head)
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        head = head.next;
    }

    // Delete node di akhir (tail)
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }

    // Delete berdasarkan posisi (indeks mulai dari 0)
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        if (position == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Posisi di luar panjang list.");
            return;
        }

        current.next = current.next.next;
    }

    // Menampilkan isi linked list
    public void display() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Main method untuk testing
    public static void main(String[] args) {
        SinglyLinkedListDeletion list = new SinglyLinkedListDeletion();

        // Tambahkan beberapa data
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.display(); // 10 -> 20 -> 30 -> 40 -> 50

        // Delete di awal
        list.deleteAtBeginning();
        list.display(); // 20 -> 30 -> 40 -> 50

        // Delete di akhir
        list.deleteAtEnd();
        list.display(); // 20 -> 30 -> 40

        // Delete di posisi tertentu (misalnya index ke-1)
        list.deleteAtPosition(1);
        list.display(); // 20 -> 40

        // Coba delete posisi yang tidak valid
        list.deleteAtPosition(10); // harusnya muncul pesan error
    }
}
