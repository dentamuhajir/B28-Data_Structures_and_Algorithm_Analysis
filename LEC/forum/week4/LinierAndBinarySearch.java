public class LinierAndBinarySearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] unsortedArray = {4, 2, 9, 1, 5, 6};
        int target1 = 5;

        int linearResult = linearSearch(unsortedArray, target1);
        if (linearResult != -1) {
            System.out.println("Linear Search: " + target1 + " ditemukan di index " + linearResult);
        } else {
            System.out.println("Linear Search: " + target1 + " tidak ditemukan.");
        }

        int[] sortedArray = {1, 2, 4, 5, 6, 9};
        int target2 = 5;

        int binaryResult = binarySearch(sortedArray, target2);
        if (binaryResult != -1) {
            System.out.println("Binary Search: " + target2 + " ditemukan di index " + binaryResult);
        } else {
            System.out.println("Binary Search: " + target2 + " tidak ditemukan.");
        }
    }
}
