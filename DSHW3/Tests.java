import Lists.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests {
	public static void main(String[] args) {


/*		ex1 test
		Integer[] myints = {1, 2, 4, 5, 5, 5, 6, 7, 7, 7, 7, 8, 8, 8};
		SLL<Integer> list = new SLL<Integer>(myints);
		list.rmDbs();
		list.print();
*/

/*		ex2 test
		CLL<Integer> clist = new CLL<>();
		// clist.addFirst(97);
		clist.addFirst(94);
		clist.addFirst(97);
		clist.addFirst(100);
		clist.addFirst(99);
		System.out.println(clist.average());
*/

        // Integer[] arr1 = {15, 7, 3, 56};
        // Integer[] arr2 = {3, 11, 12, 20, 45, 34, 45, 6};
        // SLL<Integer> list1 = new SLL<Integer>(arr1);
        // SLL<Integer> list2 = new SLL<Integer>(arr2);

        // SLL.mergeL1L2(list1.head, list2.head);

        // list1.reverseRec();
        // list1.print();

        Integer[] num2 = {1, 3, 4, 6, 7, 8, 9};
        Integer[] num1 = {2, 3, 4, 6, 7, 8, 9};


		GiantNumber x = new GiantNumber(num1);
		GiantNumber y = new GiantNumber(num2);

		// x.print();
		// y.print();
		// x.add(y);
		// x.print();

		x.subtract(y);
		x.print();

	}
}