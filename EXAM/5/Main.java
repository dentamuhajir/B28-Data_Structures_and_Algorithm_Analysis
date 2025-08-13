import java.util.Locale; // Digunakan untuk konversi huruf ke uppercase secara konsisten

public class Main {

    // ===== Node untuk Linked List di setiap bucket (chaining) =====
    static class Node {
        String key; // data yang disimpan (contoh: "Motor", "Mobil")
        Node next;  // pointer ke Node berikutnya di bucket yang sama (jika collision)

        Node(String key) {
            this.key = key;
        }
    }

    // ===== Hash Table dengan Chaining =====
    static class HashTableChaining {
        private final int size;  // ukuran tabel hash (jumlah bucket)
        private final Node[] table; // array of linked list (masing-masing bucket)

        // Constructor: membuat tabel hash kosong dengan ukuran tertentu
        public HashTableChaining(int size) {
            this.size = size;
            this.table = new Node[size]; // inisialisasi array bucket
        }

        /**
         * Fungsi hash:
         * - Mengubah string ke uppercase
         * - Menjumlahkan posisi huruf (A=1, B=2, ..., Z=26)
         * - Mengambil modulus dengan ukuran tabel untuk dapatkan index
         */
        private int hash(String s) {
            int sum = 0;
            String upper = s.toUpperCase(Locale.ROOT); // pastikan huruf besar semua
            for (int i = 0; i < upper.length(); i++) {
                char c = upper.charAt(i);
                if (c >= 'A' && c <= 'Z') { // hanya hitung huruf
                    sum += (c - 'A' + 1);  // konversi A=1, B=2, ...
                }
            }
            return sum % size; // modulus untuk menentukan bucket
        }

        /**
         * Menambahkan elemen ke tabel hash
         * - Jika bucket kosong, langsung isi
         * - Jika sudah ada (collision), tambahkan ke ekor linked list
         * - Jika key sudah ada, tidak dimasukkan lagi (opsional)
         */
        public void insert(String key) {
            int idx = hash(key);       // hitung index bucket dari key
            Node n = new Node(key);    // buat node baru untuk data

            if (table[idx] == null) {
                // Jika bucket kosong, taruh langsung di sini
                table[idx] = n;
            } else {
                // Jika sudah ada data di bucket (collision), chaining
                Node cur = table[idx];
                // Telusuri sampai akhir linked list
                while (cur.next != null) {
                    // Jika key sudah ada di tabel, jangan masukkan lagi
                    if (cur.key.equals(key)) return;
                    cur = cur.next;
                }
                // Cek elemen terakhir apakah sama dengan key yang dimasukkan
                if (cur.key.equals(key)) return;
                // Tambahkan node baru di akhir linked list
                cur.next = n;
            }

            // Info proses insert untuk debugging
            System.out.printf("Insert %-7s -> index %d%n", key, idx);
        }

        /**
         * Mengecek apakah key ada di dalam tabel
         * - Menggunakan hash untuk menentukan bucket
         * - Menelusuri linked list pada bucket tersebut
         */
        public boolean contains(String key) {
            int idx = hash(key);      // tentukan bucket dari key
            Node cur = table[idx];    // ambil head linked list pada bucket tersebut
            while (cur != null) {     // telusuri sampai habis
                if (cur.key.equals(key)) return true; // ditemukan
                cur = cur.next;
            }
            return false; // tidak ditemukan
        }

        /**
         * Mencetak isi tabel hash
         * - Format: index: data1 -> data2 -> data3 ...
         * - Jika bucket kosong, tampilkan "(empty)"
         */
        public void printTable() {
            for (int i = 0; i < size; i++) {
                System.out.print(i + ": ");
                Node cur = table[i];
                if (cur == null) {
                    System.out.println("(empty)");
                } else {
                    while (cur != null) {
                        System.out.print(cur.key);
                        cur = cur.next;
                        if (cur != null) System.out.print(" -> "); // tanda panah antar node
                    }
                    System.out.println();
                }
            }
        }
    }

    // ===== Demo sesuai poin (a) =====
    public static void main(String[] args) {
        // Data yang akan dimasukkan ke tabel hash
        String[] data = {"Motor", "Mobil", "Bus", "Truk", "Kereta", "Sepeda", "Kapal"};

        // Buat hash table dengan ukuran 7 bucket
        HashTableChaining ht = new HashTableChaining(7);

        // Masukkan data satu per satu, sambil cetak kondisi tabel
        for (String s : data) {
            ht.insert(s);    // insert data ke tabel hash
            ht.printTable(); // cetak kondisi tabel setelah insert
            System.out.println();
        }

        // Contoh pengecekan apakah data ada di tabel
        System.out.println("Contains 'Truk'?   " + ht.contains("Truk"));   // true
        System.out.println("Contains 'Pesawat'?" + ht.contains("Pesawat")); // false
    }
}
