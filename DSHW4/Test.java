import Assignment4.*;
public class Test {

	public static void main(String[] args) {
		// LinkedStack<Integer> arst = new LinkedStack<Integer>();
		// arst.push(1);
		// arst.push(2);
		// arst.push(5);
		// arst.push(3);
		// arst.push(1);
		// arst.push(10);
		// arst.push(32);
		// arst.push(11);

		// arst.sort();

		// while(!arst.isEmpty()) {
		// 	System.out.println(arst.pop());
		// }

		//System.out.println(Palindrome.isPalindrome("abababababa"));

		// CLL<Integer> ints = new CLL<Integer>();
		// ints.addFirst(12);
		// ints.addFirst(23);
		// ints.addFirst(34);
		// ints.addFirst(45);


		// // ints.rotate();
		// // ints.removeFirst();

		// ints.print();

		UnlimitedStack<Integer> unlims = new UnlimitedStack<Integer>(4);
		unlims.push(1);
		unlims.push(2);
		unlims.push(3);
		unlims.push(4);
		unlims.push(5);
		unlims.push(6);
		unlims.pop();
		unlims.pop();
		unlims.pop();
		unlims.pop();

		System.out.println(unlims.top());
	}
}