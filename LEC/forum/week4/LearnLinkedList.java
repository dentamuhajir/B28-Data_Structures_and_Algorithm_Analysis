import java.util.LinkedList;

public class LearnLinkedList {
    public static void main(String[] args) {
        LinkedList<String> food = new LinkedList<String>();
        food.add("Nasi Goreng");
        food.add("Kwietiw");

        food.addFirst("Pizza hut");
        food.push("Be number One");
        food.addLast("Gulali");
        for(String item : food) {
            System.out.println(item);
        }

  /*
===================================================================================
| Metode            | Fungsi                                          | Struktur Mirip   |
|-------------------|--------------------------------------------------|------------------|
| add(E e)          | Tambah di akhir list                             | List             |
| addFirst(E e)     | Tambah di depan                                  | Deque / Queue    |
| addLast(E e)      | Tambah di belakang                               | Deque / Queue    |
| push(E e)         | Tambah di depan (alias addFirst, untuk Stack)   | Stack            |

| get(int index)    | Ambil elemen berdasarkan index                   | List             |
| getFirst()        | Ambil elemen pertama                             | Deque / Queue    |
| getLast()         | Ambil elemen terakhir                            | Deque / Queue    |
| peek()            | Lihat elemen pertama tanpa menghapus             | Queue / Stack    |

| remove()          | Hapus elemen pertama                             | Queue            |
| removeFirst()     | Hapus elemen pertama                             | Deque / Stack    |
| removeLast()      | Hapus elemen terakhir                            | Deque            |
| pop()             | Ambil & hapus elemen pertama (alias removeFirst) | Stack            |
| poll()            | Ambil & hapus elemen pertama, null jika kosong   | Queue            |

| size()            | Cek jumlah elemen                                | Collection       |
| isEmpty()         | Cek apakah list kosong                           | Collection       |
===================================================================================
*/


    }
}

