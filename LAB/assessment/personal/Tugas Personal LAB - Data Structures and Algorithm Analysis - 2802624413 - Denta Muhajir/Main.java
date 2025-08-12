import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inisialisasi array
        int[] initialArrayData = { 3, 2, 6, 8, 9, 1}; 
        ArrayOperation arrayOperation = new ArrayOperation(initialArrayData);

        // Inisialisasi array list
        ArrayListOperation arrayListOperation = new ArrayListOperation(new ArrayList<>(Arrays.asList(3, 2, 6, 8, 9, 1)));
        
        // --- Operasi Traversal ---
        System.out.print("Array Traversal: ");
        long startTimeArrayTraversal = System.nanoTime();
        arrayOperation.show();
        long endTimeArrayTraversal = System.nanoTime();
        double durationArrayTraversal = (endTimeArrayTraversal - startTimeArrayTraversal) / 1_000_000.0;
        System.out.println("Waktu eksekusi Array Traversal: " + durationArrayTraversal + " ms");

        System.out.print("ArrayList Traversal: ");
        long startTimeArrayListTraversal = System.nanoTime();
        arrayListOperation.show();
        long endTimeArrayListTraversal = System.nanoTime();
        double durationArrayListTraversal = (endTimeArrayListTraversal - startTimeArrayListTraversal) / 1_000_000.0;
        System.out.println("Waktu eksekusi ArrayList Traversal: " + durationArrayListTraversal + " ms");

        // --- Operasi Search ---
        int findData = 1;

        System.out.print("\nPencarian " + findData +" dalam Array: ");
        long startTimeArraySearch = System.nanoTime();
        int resultArray = arrayOperation.search(findData);
        long endTimeArraySearch = System.nanoTime();
        double durationArraySearch = (endTimeArraySearch - startTimeArraySearch) / 1_000_000.0;
        System.out.println("Ditemukan di indeks " + resultArray + " (Waktu eksekusi: " + durationArraySearch + " ms)");

        System.out.print("Pencarian " + findData + " dalam ArrayList: ");
        long startTimeArrayListSearch = System.nanoTime();
        int resultArrayList = arrayListOperation.search(findData);
        long endTimeArrayListSearch = System.nanoTime();
        double durationArrayListSearch = (endTimeArrayListSearch - startTimeArrayListSearch) / 1_000_000.0;
        System.out.println("Ditemukan di indeks " + resultArrayList + " (Waktu eksekusi: " + durationArrayListSearch + " ms)");

        // --- Operasi Add Data ---
        int addNumber = 4;

        System.out.print("\nArray setelah penyisipan elemen " + addNumber + " : ");
        long startTimeArrayAdd = System.nanoTime();
        arrayOperation.add(addNumber);
        long endTimeArrayAdd = System.nanoTime();
        double durationArrayAdd = (endTimeArrayAdd - startTimeArrayAdd) / 1_000_000.0;
        arrayOperation.show();
        System.out.println("Waktu eksekusi penambahan elemen pada Array: " + durationArrayAdd + " ms");


        System.out.print("ArrayList setelah penyisipan elemen " + addNumber + " : ");
        long startTimeArrayListAdd = System.nanoTime();
        arrayListOperation.add(addNumber);
        long endTimeArrayListAdd = System.nanoTime();
        double durationArrayListAdd = (endTimeArrayListAdd - startTimeArrayListAdd) / 1_000_000.0;
        arrayListOperation.show();
        System.out.println("Waktu eksekusi penambahan elemen pada ArrayList: " + durationArrayListAdd + " ms");

        // --- Operasi Remove Data ---
        int removeNumber = 8;

        System.out.print("\nArray setelah penghapusan elemen " + removeNumber + " : " );
        long startTimeArrayDelete = System.nanoTime();
        arrayOperation.delete(removeNumber);
        long endTimeArrayDelete = System.nanoTime();
        double durationArrayDelete = (endTimeArrayDelete - startTimeArrayDelete) / 1_000_000.0;
        arrayOperation.show();
        System.out.println("Waktu eksekusi penghapusan elemen pada Array: " + durationArrayDelete + " ms");

        System.out.print("ArrayList setelah penghapusan elemen " + removeNumber + " : ");
        long startTimeArrayListDelete = System.nanoTime();
        arrayListOperation.delete(removeNumber);
        long endTimeArrayListDelete = System.nanoTime();
        double durationArrayListDelete = (endTimeArrayListDelete - startTimeArrayListDelete) / 1_000_000.0;
        arrayListOperation.show();
        System.out.println("Waktu eksekusi penghapusan elemen pada ArrayList: " + durationArrayListDelete + " ms");
    }
}

class ArrayOperation {
    private int[] data;

    public ArrayOperation(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
    }

    // Metode untuk menampilkan array dengan perulangan 
    void show() {
        int[] tempArrayForDisplay = Arrays.copyOf(this.data, this.data.length); 
        Arrays.sort(tempArrayForDisplay); 
        
        System.out.print("[");
        for (int i = 0; i < tempArrayForDisplay.length; i++) {
            System.out.print(tempArrayForDisplay[i]);
            if (i < tempArrayForDisplay.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Metode untuk search array menggunakan cara binary search
    public int search(int target) {
        Arrays.sort(this.data);
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == target) {
                return i; // Mengembalikan indeks elemen yang ditemukan
            }
        }
        return -1; // Jika elemen tidak ditemukan
    }

    // Metode untuk menyisipkan attay
    public void add(int valueToAdd) {
        int[] newArray = new int[this.data.length + 1];
        System.arraycopy(this.data, 0, newArray, 0, this.data.length);
        newArray[this.data.length] = valueToAdd;
        this.data = newArray; // Perbarui array existing

    }

    // Metode untuk remove array berdasarkan valuenya
    public void delete(int valueToRemove) {
        int indexToRemove = -1;

        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] == valueToRemove) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            System.out.println("Elemen " + valueToRemove + " tidak ditemukan.");
            return;
        }

        int[] newArray = new int[this.data.length - 1];

        if (indexToRemove > 0) {
            System.arraycopy(this.data, 0, newArray, 0, indexToRemove);
        }

        if (indexToRemove < this.data.length - 1) {
            System.arraycopy(this.data, indexToRemove + 1, newArray, indexToRemove, this.data.length - indexToRemove - 1);
        }

        this.data = newArray;
    }
}

class ArrayListOperation {
    private List<Integer> data;

    // Inisialisasi konstruktor
    public ArrayListOperation(List<Integer> data) {
        this.data = new ArrayList<>(data); 
    }

    // Metode menampilkan ArrayList kurang lebih sama dengan arryOperation show logicnya
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

    // Metode pencarian dengan memanfaatkan built in function indexOf di arrayList
    public int search(int target) {
        Collections.sort(data); 
        return data.indexOf(target);
    }

    // Metode penyisipan dengan memanfaatkan built in function add di arrayList
    public void add(int newData) {
        data.add(newData);
    }


    // Metode penghapusan arrayList dengan memanfaatkan built in function remove di arrayList
    public void delete(int valueToRemove) {
        boolean removed = data.remove((Integer) valueToRemove);
        if (!removed) {
            System.out.println("Elemen " + valueToRemove + " tidak ditemukan.");
        }
    }
}

