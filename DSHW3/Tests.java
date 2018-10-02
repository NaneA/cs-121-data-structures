import Lists.SLL;

public class Tests {
	public static void main(String[] args) {
		Integer[] myints = {1, 2, 4, 5, 5, 5, 6, 7, 7, 7, 7, 8, 8, 8};
		SLL<Integer> list = new SLL<Integer>(myints);
		list.rmDbs();
		list.print();
	}
}