import java.time.chrono.ThaiBuddhistChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        int[] data = { 3, 2, 6, 8, 9, 1};
        
        //int[] data = new int[1000];
        // for (int i = 0; i < data.length; i++) {
        //     data[i] = i + 1; // Fill from 1 to 1000
        // }

        ArrayOperation arrayOperation =  new ArrayOperation(data);
        System.out.print("Array Traversal: ");
        arrayOperation.show();

        List<Integer> dataArrayList = Arrays.asList(3, 2, 6, 8, 9, 1); // from array to ArrayList
        ArrayListOperation arrayListOperation = new ArrayListOperation(new ArrayList<>(dataArrayList));

        System.out.print("ArrayList Traversal: ");
        arrayListOperation.show();
        

        // Operasi search
        int findData = 1;

        int resultArray = arrayOperation.search(findData);
        System.out.println("\nPencarian " + findData +" dalam Array: Ditemukan di indeks " + resultArray);
        
        int resultArrayList = arrayListOperation.search(findData);
        System.out.println("Pencarian " + findData + " dalam ArrayList: Ditemukan di indeks " + resultArrayList);
    
        // Operasi add data
        int addNumber = 4;

        arrayOperation.add(addNumber);
        System.out.print("\nArray setelah penyisipan elemen " + addNumber + " : ");
        arrayOperation.show();

        arrayListOperation.add(addNumber);
        System.out.print("ArrayList setelah penyisipan elemen " + addNumber + " : ");
        arrayListOperation.show();

        // Operasi Remove data
        int removeNumber = 8;

        arrayOperation.delete(removeNumber);
        System.out.print("\nArray setelah penghapusan elemen " + removeNumber + " : " );
        arrayOperation.show();

        arrayListOperation.delete(removeNumber);
        System.out.print("ArrayList setelah penghapusan elemen " + removeNumber + " : ");
        arrayListOperation.show();

    }
    
}


class ArrayOperation {
    // int[] data = { 3, 2, 6, 8, 9, 1};
    private int[] data;

    public ArrayOperation(int[] data) {
        this.data = data;
    }

    
    void show() {
        // Sort data array dari kecil ke besar
        Arrays.sort(this.data);
        
        System.out.print("[");
        for (int i = 0; i < this.data.length; i++) {
            System.out.print(data[i]);
            if (i < this.data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    
    public int search(int target) {
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == target) {
                return i; // Mengembalikan indeks elemen yang ditemukan
            }
        }
        return -1; // Jika elemen tidak ditemukan
    }

    public void  add(int valueToAdd) {
        int[] newArray = new int[this.data.length + 1];
    
        // Salin semua elemen lama ke array baru
        System.arraycopy(this.data, 0, newArray, 0, data.length);
    
        // Tambahkan elemen baru di akhir
        newArray[this.data.length] = newData;
    
        this.data = newArray; 
    }

    public void delete(int valueToRemove) { // Tidak lagi menerima parameter 'arr' dan tidak ada return type
    int indexToRemove = -1;

    // Cari index elemen yang ingin dihapus di dalam this.data
    for (int i = 0; i < this.data.length; i++) {
        if (this.data[i] == valueToRemove) {
            indexToRemove = i;
            break;
        }
    }

    // Jika elemen tidak ditemukan, cetak pesan dan keluar (tidak perlu return array)
    if (indexToRemove == -1) {
        System.out.println("Elemen " + valueToRemove + " tidak ditemukan.");
        return;
    }

    // Buat array baru dengan ukuran yang lebih kecil
    int[] newArray = new int[this.data.length - 1];

    // Salin bagian sebelum index yang dihapus
    if (indexToRemove > 0) {
        System.arraycopy(this.data, 0, result, 0, indexToRemove);
    }

    // Salin bagian setelah index yang dihapus
    if (indexToRemove < this.data.length - 1) {
        System.arraycopy(this.data, indexToRemove + 1, result, indexToRemove, this.data.length - indexToRemove - 1);
    }

    // Perbarui array internal instance ini dengan array yang baru
    this.data = newArray;
}

    // public static void measure(String name, Runnable task) {
    //     long start = System.nanoTime();
    //     task.run();
    //     long end = System.nanoTime();
    //     double durationMs = (end - start) / 1_000_000.0;
    //     System.out.println("Waktu eksekusi "+ name + " pada Array: : " + durationMs + " ms");
    // }
}


class ArrayListOperation {
    private List<Integer> data;

    public ArrayListOperation(List<Integer> data) {
        this.data = data;
    }

    // Menampilkan isi ArrayList (tersortir)
    public void show() {
        List<Integer> sorted = new ArrayList<>(data);
        Collections.sort(sorted);
        System.out.print("[");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.print(sorted.get(i));
            if (i < sorted.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Mencari nilai dalam list
    public int search(int target) {
        Collections.sort(data);
        return data.indexOf(target); // -1 if not found
    }

    // Menambahkan elemen ke list
    public void add(int newData) {
        data.add(newData);
    }

    // Menghapus elemen pertama yang ditemukan
    public void delete(int valueToRemove) {
        boolean removed = data.remove((Integer) valueToRemove);
        if (!removed) {
            System.out.println("Elemen " + valueToRemove + " tidak ditemukan.");
        }
    }
}
