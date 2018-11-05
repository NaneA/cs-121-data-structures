package Assignment4;
public class UniqueQueue<E> implements Queue<E> {
	private SLL<E> list = new SLL<E>();

	public Queue() {}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(E e) {
		if(!list.has(e)) {
			list.addLast(e);
		}
	}

	public E first() {
		return list.first();
	}

	public E dequeue() {
		return list.removeFirst();
	}

}