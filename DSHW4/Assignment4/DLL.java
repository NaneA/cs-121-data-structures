package Assignment4;
public class DLL<E> {
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() { 
			return element; 
		}

		public Node<E> getPrev() { 
			return prev; 
		}

		public Node<E> getNext() { 
			return next; 
		}

		public void setPrev(Node<E> p) { 
			prev = p; 
		}

		public void setNext(Node<E> n) { 
			next = n; 
		}
	}

	private Node<E> header; // header sentinel
	private Node<E> trailer; // trailer sentinel
	private int size = 0; // number of elements in the list

	public DLL() {
		header = new Node<>(null, null, null); // create header
		trailer = new Node<>(null, header, null); // trailer is preceded by header
		header.setNext(trailer); // header is followed by trailer
	}

	public int size() { 
		return size; 
	}

	public boolean isEmpty() { 
		return size == 0; 
	}

	public E first( ) {
		if (isEmpty()) {
			return null;
		}
		return header.getNext().getElement(); // first element is beyond header
	}

	public E last( ) {
		if (isEmpty()) {
			return null;
		}
		return trailer.getPrev().getElement(); // last element is before trailer
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext()); // place just after the header
	}

	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null; // nothing to remove
		}
		return remove(header.getNext()); // first element is beyond header
	}

	public E removeLast( ) {
		if (isEmpty( )) {
			return null; // nothing to remove
		}
		return remove(trailer.getPrev( )); // last element is before trailer
	}

	// private update methods

	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// create and link a new node
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev( );
		Node<E> successor = node.getNext( );
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement( );
	}
}