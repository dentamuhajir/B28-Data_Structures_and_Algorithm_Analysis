public class MainSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.printList(); 
        
    }
    
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {
    Node head;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // jika kosong
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // pindah ke node berikutnya
            }
            current.next = newNode;
        }
    }

    // Menampilkan isi linked list
    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("null");
    }
}