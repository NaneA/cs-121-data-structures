import ElementaryDataStructures.SLL;

public class Tests {
	public static void main(String[] args) {
		SLL<Integer> myints = new SLL<Integer>(new Integer[]{5, 3, 1, 2, 4, 6});
		SLL<SLL<Integer>> mylists = new SLL<SLL<Integer>>();
		mylists.addFirst(myints);
		
		
		myints.reverseRec();
		myints.insertionSort();
		myints.increment();
		SLL.increment2D(mylists);
		myints.print();
	}
}