public class SinglyLinkedListInsertion {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked list head
    Node head;

    // Insert di awal (head)
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert di akhir (tail)
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

    // Insert di posisi tertentu (index mulai dari 0)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Posisi di luar panjang list.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
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

    // Main method
    public static void main(String[] args) {
        SinglyLinkedListInsertion list = new SinglyLinkedListInsertion();

        // Insert di akhir
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display(); // 10 -> 20 -> 30

        // Insert di awal
        list.insertAtBeginning(5);
        list.display(); // 5 -> 10 -> 20 -> 30

        // Insert di posisi tertentu
        list.insertAtPosition(15, 2); // di antara 10 dan 20
        list.display(); // 5 -> 10 -> 15 -> 20 -> 30

        list.insertAtPosition(100, 10); // invalid position
    }
}
