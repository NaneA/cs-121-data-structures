package Lists;
public class SLL<E> {
    
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {
            return element;
        }
        
        public Node<E> getNext() {
            return next;
        }
        
        public void setNext(Node<E> node) {
            next = node;
        }

        public void setElement(E e) {
            element = e;
        }
    }
    
    private int size;
    private Node<E> head = null;
    private Node<E> tail = null;

    //constructors
    public SLL() {}
    
    public SLL(E arr[]) {
        for(int i = 0; i < arr.length; i++) {
            addFirst(arr[i]);
        }
    }

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    //access methods
    public E first() {
        if(!isEmpty()) {
            return head.getElement();
        }
        return null;
    }
    
    public E last() {
        if(!isEmpty()) {
            return tail.getElement();
        }
        return null;
    }
    
    public E getAt(int i) {
        if(i >= size || i < 0) {
            return null;
        }
        Node<E> el = head;
        while(i > 0) {
            el = el.getNext();
        }
        return el.getElement();
    }
    
    //update methods
    
    public void addFirst(E el) {
        head = new Node<>(el, head);
        if(isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E el) {
        Node<E> newest = new Node<E>(el, null);
        if(isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        size++;
    }

    public void addAt(E el, int i) {
        if(i < 0 || i > size - 1) {
            return;
        }
        if(i == 0) {
            addFirst(el);
        } else if(i == size - 1) {
            addLast(el);
        }

        Node<E> prev = head;
        while(i > 0) {
            prev = prev.next;
            i--;
        }
        Node<E> newest = new Node<E>(el, prev.next);
        prev.setNext(newest);
    }

    public E removeFirst() {
        if(isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty()) {
            tail = null;
        }
        return answer;
    }

    public void print() {
        Node<E> cur = head;
        while(cur != null) {
            System.out.println(cur.getElement());
            cur = cur.next;
        }
    }

    private void removeDubs(Node<Integer> h) {
    	if(h==null) {
    		return;
    	}

    	Node<Integer> cur = h;
    	Node<Integer> prev;

    	while(cur.getNext() != null) {
    		if(cur.getElement() == cur.getNext().getElement()) {
    			cur.setNext(cur.getNext().getNext());
                size--;
    		} else {
    			cur = cur.getNext();
    		}
    	}
    }

    public void rmDbs() {
        removeDubs((Node<Integer>)head);
    }
}