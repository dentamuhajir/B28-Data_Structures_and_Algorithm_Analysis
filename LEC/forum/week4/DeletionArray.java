public class DeletionArray {
    public static void main(String[] args) {
        int[] originalArray = {3, 8, 5, 2, 9};
        int deleteValue = 5;

        int[] newArray = deleteElement(originalArray, deleteValue);

        System.out.print("Array setelah dihapus: ");
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] deleteElement(int[] arr, int valueToDelete) {
        int count = 0;

        // Hitung berapa elemen yang tidak sama dengan valueToDelete
        for (int num : arr) {
            if (num != valueToDelete) {
                count++;
            }
        }

        // Jika tidak ada yang dihapus, kembalikan array asli
        if (count == arr.length) {
            return arr;
        }

        int[] result = new int[count];
        int index = 0;

        for (int num : arr) {
            if (num != valueToDelete) {
                result[index++] = num;
            }
        }

        return result;
    }
}
