package Lists;
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

        private void setElement(E e) {
            element = e;
        }
    }

    private int size = 0;

    //this is a dangerous idea, but I don't know other way to do ex3
    //sorry encapsulation
    public Node<E> head = null;
    private Node<E> tail = null;

    public Node<E> getHead() {
        return head;
    }
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

    public void print() {
        Node<E> cur = head;
        while(cur != null) {
            System.out.println(cur.getElement());
            cur = cur.next;
        }
    }

    public E removeNext(Node<E> prev) {
        if(prev.getNext() == null) {
            return null;
        }
        E val = prev.getNext().getElement();
        prev.setNext(prev.getNext().getNext());
        size--;
        if(prev.getNext() == null) {
            tail = prev;
        }
        return val;
    }

    //ex1
    private void removeDubs(Node<Integer> h) {
        if(h == null) {
            return;
        }

        Node<Integer> cur = h;

        while(cur.getNext() != null) {
            if(cur.getElement() == cur.getNext().getElement()) {
                removeNext((Node<E>)cur);
            } else {
                cur = cur.getNext();
            }
        }
    }
    //end ex1

    public void rmDbs() {
        removeDubs((Node<Integer>)head);
    }

    //ex3
    public static void mergeL1L2(Node<Integer> l1, Node<Integer> l2) {
        while(l1 != null && l2 != null) {
            Node<Integer> newest = new Node<Integer>(l2.getElement(), l1.getNext());
            l1.setNext(newest);
            l1 = l1.getNext().getNext();
            l2 = l2.getNext();
        }
    }
    //end ex3

    //ex4
    private Node<E> reverseRecHelper(Node<E> node) {
        if(node.next == null) {
            return node;
        }
        Node<E> rest = reverseRecHelper(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    public Node<E> reverseRec() {
        head = reverseRecHelper(head);
        return head;
    }
}