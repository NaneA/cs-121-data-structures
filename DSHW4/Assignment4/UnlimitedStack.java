package Assignment4;
public class UnlimitedStack<E> implements Stack<E> {
	private int size;
	private DLL<E> list = new DLL<E>();


	public UnlimitedStack(int size) {
		this.size = size;
	}
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(E e) {
		list.addFirst(e);
		if(size < list.size()) {
			list.removeLast();
		}
	}

	public E top() {
		return list.first();
	}

	public E pop() {
		return list.removeFirst();
	}
}