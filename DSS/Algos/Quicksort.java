public class Quicksort {

	private static void QuicksortHelper(int[] arr, int i, int j) {
		if(i < j) {
			int p = partition(arr, i, j);
			QuicksortHelper(arr, i, p-1);
			QuicksortHelper(arr, p, j);
		}
	}

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
	
	public static void QuickSort(int[] arr) {
		QuicksortHelper(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 56, 3, 4, 3, 23, 7, 8};
		QuickSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}