import ElementaryDataStructures.SLL;

public class Tests {
	public static void main(String[] args) {
		SLL<Integer> myints = new SLL<Integer>(new Integer[]{5, 3, 1, 2, 4, 6});
		SLL<SLL<Integer>> mylists = new SLL<SLL<Integer>>();
		mylists.addFirst(mylists);
		
		
		myints.reverseRec();
		myints.insertionSort();
		myints.increment();
		mylists.increment2D();
		myints.print();
	}
}