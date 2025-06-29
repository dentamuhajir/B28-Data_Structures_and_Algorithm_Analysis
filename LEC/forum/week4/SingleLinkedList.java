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

    void printAll() {
        SinglyNode current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");

    }

}

public class SingleLinkedList {
    public static void main(String[] args) {
        Process testSingleLinkList = new Process();
        testSingleLinkList.add(3);
        testSingleLinkList.add(5);
        testSingleLinkList.add(65);
        testSingleLinkList.add(21);

        testSingleLinkList.printAll();

    }
}

/*
========================================================================================
| Istilah / Nama Variabel | Tipe Data        | Fungsi / Kegunaan                        |
|--------------------------|------------------|-------------------------------------------|
| head                    | Node              | Menunjuk ke node pertama dalam list       |
| tail                    | Node              | (Opsional) Menunjuk ke node terakhir      |
| next                    | Node              | Menunjuk ke node berikutnya (singly/doubly)|
| prev                    | Node              | Menunjuk ke node sebelumnya (doubly only) |
| current                 | Node              | Digunakan saat traversal/loop             |
| newNode                 | Node              | Node baru yang ingin ditambahkan          |
| null                    | keyword (null)    | Tanda akhir dari linked list              |
| size                    | int               | Jumlah elemen dalam list (jika disimpan)  |
| data / value            | Tipe generic/int  | Nilai yang disimpan dalam suatu node      |
| iterator()              | method            | Untuk for-each loop jika pakai Iterable   |
========================================================================================
*/

