public class Quicksort {

	private void QuicksortHelper(int[] arr, int i, int j) {
		if(i < j) {
			int p = partition(arr, i, j);
			QuicksortHelper(arr, i, j-1);
			QuicksortHelper(arr, p+1, j);
		}
	}
	
}