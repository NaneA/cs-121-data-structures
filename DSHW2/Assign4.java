public class Assign4 {
	public static void merge(int[] left, int[] right, int[] arr) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0, j = 0, k = 0;
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			} else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		while (i < leftSize) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while (j < rightSize) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}

	public static void mergeSort(int[] inputArray) {
		int size = inputArray.length;
		if (size < 2) {
			return;
		}
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for (int i = 0; i < mid; i++){
			left[i] = inputArray[i];
		}
		for (int i = mid; i < size; i++) {
			right[i - mid] = inputArray[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, inputArray);
	}

	public static int[] checkInSortedArray(int[] arr, int x, int start, int end) {
		if(start > end){
			return null;
		} else if(arr[start] + arr[end] == x) {
			int[] result = {arr[start], arr[end]};
			return result;
		} else if(arr[start] + arr[end] > x) {
			return checkInSortedArray(arr, x, start, end-1);
		} 
		return checkInSortedArray(arr, x, start+1, end);
	}

	public static int[] checkInUnsortedArray(int[] arr, int x) {
		mergeSort(arr); //O(nlog(n))
		return checkInSortedArray(arr, x, 0, arr.length-1); //Օ(n)
	} // O(nlog(n)) + O(n) = O(nlog(n))

	public static void main(String[] args) {
		int[] input = {3, 4, 5, 6, 734, 2, 7, 9};
		int[] output = new int[2];
		int x = 9;
		output = checkInUnsortedArray(input, x);
		if(output != null) {
			System.out.println(output[0] + "+" + output[1] + "=" + x);
		} else {
			System.out.println("Not found");
		}
	}
}