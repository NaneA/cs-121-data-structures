public class MultiplyK {

    private static int multiplyKHelper(int[] arr, int k, int index) throws IllegalArgumentException {
        if(k > arr.length || k < 0) {
            throw new IllegalArgumentException("Passed " + Integer.toString(k) + ", should be between 1 and arr.length");
        }

        if(k == 0 || index == arr.length) {
            return 1;
        }

        if(arr[index] < 0) {
            return multiplyKHelper(arr, k, index+1);
        } else {
            return arr[index] * multiplyKHelper(arr, k - 1, index +1);
        }
    }
    public static int multiplyK(int[] arr, int k) throws IllegalArgumentException {
        return multiplyKHelper(arr, k, 0);
    }

    public static void main(String[] args) {
        int[] arr = {-3, 4, 2, -5, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(multiplyK(arr, 0));
        System.out.println(multiplyK(arr, 5));
        System.out.println(multiplyK(arr, 5));
        System.out.println(multiplyK(arr, 1));
        System.out.println(multiplyK(arr, 10)); 
    }
}
