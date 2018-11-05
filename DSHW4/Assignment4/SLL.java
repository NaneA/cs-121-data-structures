package Assignment4;
public class SLL<E> {
    public static class Node<E> {
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

        private void setNext(Node<E> node) {
            next = node;
        }

        public void setElement(E e) {
            element = e;
        }
    }

    private int size = 0;

    private Node<E> head = null;
    private Node<E> tail = null;

    //constructors
    public SLL() {}

    public SLL(E arr[]) {
        for(int i = arr.length - 1; i >= 0; i--) {
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
        if(this.isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
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

    public boolean has(E e) {
        Node<E> cur = head;
        while(cur != null) {
            if(cur.getElement().equals(e)) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
}