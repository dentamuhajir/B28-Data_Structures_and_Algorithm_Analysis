import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Test data");
        
        int[] data = { 3, 2, 6, 8, 9, 1};
        ArrayOperation arrayOperation =  new ArrayOperation(data);
        System.out.print("Array Traversal: ");
        arrayOperation.show(data);

        // Operasi search
        int findData = 1;
        int result = arrayOperation.search(data,findData);
        System.out.println("\nPencarian " + findData +" dalam Array: Ditemukan di indeks " + result);
    
        // Operasi add data
        int addNumber = 4;
        int[] addArray = arrayOperation.add(data, addNumber);
        System.out.print("\nArray setelah penyisipan elemen " + addNumber + " : ");
        arrayOperation.show(addArray);

        // Operasi Remove data
        int removeNumber = 8;
        int[] removeArray = arrayOperation.delete(addArray, removeNumber);
        System.out.print("\nArray setelah penghapusan elemen " + removeNumber + " : " );
        arrayOperation.show(removeArray);

        //System.out.println("Array setelah disisipkan " + arrayOperation.showData(addArray));
    }
    
}


class ArrayOperation {
    // int[] data = { 3, 2, 6, 8, 9, 1};
    private int[] data;

    public ArrayOperation(int[] data) {
        this.data = data;
    }

    
    void show(int[] data) {
        // Sort data array dari kecil ke besar
        Arrays.sort(data);
        
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
            if (i < data.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    
    public static int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Mengembalikan indeks elemen yang ditemukan
            }
        }
        return -1; // Jika elemen tidak ditemukan
    }

    public static int[]  add(int[]data, int newData) {
        int newArray[] = new int[data.length + 1];
        
        // Define new array untuk menampung array lama + 1 data sisipan
        //int[] newArray;
        // + 1 ini dimaksudkan karena fitur ini menambah array atau menyisipkan array jadi + 1
        for(int i = 0; i < data.length; i++ ) {
            newArray[i] = data[i];
        }

        newArray[data.length] = newData;
        //
        return newArray;

        //return data;
    }

     public static int[] delete(int[] arr, int valueToRemove) {
        // Cari index value yang ingin dihapus
        int indexToRemove = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToRemove) {
                indexToRemove = i;
                break; // hanya hapus yang pertama ditemukan
            }
        }

        // Jika value tidak ditemukan, kembalikan array asal
        if (indexToRemove == -1) {
            return arr;
        }

        // Buat array baru tanpa elemen yang ingin dihapus
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != indexToRemove) {
                result[j++] = arr[i];
            }
        }
        return result;
    }

}

    // class ArrayListOperation {

    // }
