import ElementaryDataStructures.SLL;

public class Tests {
	public static void main(String[] args) {
		SLL<Integer> myints = new SLL<Integer>(new Integer[]{5, 3, 1, 2, 4, 6});
		myints.reverseRec();
		myints.insertionSort();
		myints.increment();
		myints.print();
	}
}