public class MultiplyK {

    public static int multiplyK(int[] arr, int k) throws IllegalArgumentException {
        if(k > arr.length || k < 0) {
            throw new IllegalArgumentException("Passed " + Integer.toString(k) + ", should be between 1 and arr.length");
        }
        if(k == 0) {
            return 1;
        }
        return arr[k-1] * multiplyK(arr, k - 1);
    }

    public static void main(String[] args) {
        /* tests for the first assignment
        int[] arr = {4, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print(multiplyK(arr, 0));
        System.out.print(multiplyK(arr, 5));
        System.out.print(multiplyK(arr, -5));
        System.out.print(multiplyK(arr, 1));
        System.out.print(multiplyK(arr, 10));
        System.out.print(multiplyK(arr, 11));
        */

    }
}
