package Lists;

public class GiantNumber {
	

	//num.first() is the last digit of our number
	private SLL<Integer> num;

	public GiantNumber(){}

	public GiantNumber(SLL<Integer> num) {
		this.num = num;
	}

	public GiantNumber(Integer[] digits) {
		num = new SLL<Integer>(digits);
	}

	public void add(GiantNumber x) {
		SLL<Integer> temp = new SLL<Integer>();
		SLL.Node<Integer> h1 = num.head;
		SLL.Node<Integer> h2 = x.num.head;
		Integer remainder = 0;

		while(h1 != null || h2 != null) {
			Integer sum = (h1 != null ? h1.getElement() : 0) + (h2 != null ? h2.getElement() : 0) + remainder;
			temp.addLast(sum%10);
			remainder = sum/10;
			if(h1 != null) {
				h1 = h1.getNext();
			}
			if(h2 != null) {
				h2 = h2.getNext();
			}
		}
		if(remainder > 0) {
			temp.addLast(remainder);
		}
		num = temp;
	}

	public int digits() {
		return num.size();
	}

	public void print() {
		SLL<Integer> temp = new SLL<Integer>();
		SLL.Node<Integer> cur = num.head;
        while(cur != null) {
            temp.addFirst(cur.getElement());
            cur = cur.getNext();
        }
        cur = temp.head;
        while(cur != null) {
            System.out.print(cur.getElement());
            cur = cur.getNext();
        }
        System.out.println();
	}
}