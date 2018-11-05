import utils.*;
import java.util.Iterator;

public class Ex1 {

	public static <E> void print(E item) {
		System.out.println(item);
	}

	public static void main(String[] args) {
		// SinglyLinkedList<Integer> l1 = new SinglyLinkedList<>();

		// l1.addFirst(1);
		// l1.addFirst(14);
		// l1.addFirst(131);
		// l1.addFirst(41);
		// l1.addFirst(10);
		// l1.addFirst(90);

		// Iterator<Integer> walk = l1.altIterator();
		// while(walk.hasNext()) {
		// 	print(walk.next());
		// }

		// print(l1);

		LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();

		bt.addRoot(0);
		bt.addLeft(bt.root(), 23);
		bt.addRight(bt.root(), 45);


		bt.addLeft( bt.left( bt.root() ), 89 );
		bt.addRight( bt.left( bt.root() ), 80 );


		for(Integer i : bt) {
			print(i);
		}
	}
}