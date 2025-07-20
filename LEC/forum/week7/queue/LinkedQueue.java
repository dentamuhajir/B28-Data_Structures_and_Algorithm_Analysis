class Node {
    int val;
    Node next;
}

// LinkedQueue class with front and rear pointers
class LinkedQueue {
    Node rear = null;
    Node front = null;

    // Method to insert an element into the queue
    void insertFun(int item) {
        Node pt = new Node();
        pt.val = item;
        pt.next = null;
        if (front == null) {
            front = pt;
            rear = pt;
        } else {
            rear.next = pt;
            rear = pt;
        }
    }

    // Method to get the front element
    int getFront() {
        if (front != null) {
            return front.val;
        }
        throw new RuntimeException("Queue is empty");
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.insertFun(10);
        queue.insertFun(20);
        // Printing the front element
        System.out.println("Front element: " + queue.getFront());
    }
}