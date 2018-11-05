package Assignment4;
public class LinkedStack<E extends Comparable<E>> implements Stack<E> {
	private SLL<E> list = new SLL<E>();
	public LinkedStack() {}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void push(E e) {
		list.addFirst(e);
	}

	public E top() {
		return list.first();
	}

	public E pop() {
		return list.removeFirst();
	}

	public void sort() {
		LinkedStack<E> tempStack = new LinkedStack<E>();
		while(!isEmpty()) {
			E temp = this.pop();
			while(!tempStack.isEmpty() && tempStack.top().compareTo(temp) < 0) {
				this.push(tempStack.pop());
			}
			tempStack.push(temp);
		}

		while(!tempStack.isEmpty()) {
			this.push(tempStack.pop());
		}
	}
}