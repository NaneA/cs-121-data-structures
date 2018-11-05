package Lists;

public class GiantNumber {
	

	//num.first() is the last digit of our number
	private SLL<Integer> num;
	private boolean borrow = false;

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



	private void subHelp(SLL.Node<Integer> l1, SLL.Node<Integer> l2, int carry) {
		if(l2 == null) {
			return;
		}

		l1.setElement(l1.getElement() - carry);

		boolean dif = (l2.getElement() > l1.getElement());

		int d1 = (dif ? l1.getElement() + 10 : l1.getElement());
		int d2 = l2.getElement();

		l1.setElement(d1-d2);

		subHelp(l1.getNext(), l2.getNext(), (dif ? 1 : 0));
	}
    private void removeLeadingZeros() {
    	SLL.Node<Integer> cur = num.head;
    	SLL.Node<Integer> prev = null;
    	boolean z = true;
    	int count = 0;
    	while(cur.getNext() != null) {
    		if(cur.getNext().getElement() == 0 && z) {
    			prev = cur;
    			z = false;
    			count++;
    		} else if(cur.getNext().getElement() != 0 && !z) {
    			z = true;
    			prev = null;
    			count = 0;
    		} else {
    			count++;
    		}
    		cur = cur.getNext();
    	}

    		
    	if(prev != null) {
    		num.removeRest(prev, count);
    	}
    }

	public void subtract(GiantNumber x) {
		borrow = false;
		subHelp(num.head, x.num.head, 0);
		removeLeadingZeros();
		System.out.println(num.size());
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