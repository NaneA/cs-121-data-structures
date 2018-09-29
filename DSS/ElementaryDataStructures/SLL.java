package ElementaryDataStructures;
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

    private Node<E> reverseRecHelper(Node<E> node) {
        if(node.next == null) {
            return node;
        }
        Node<E> rest = reverseRecHelper(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    //fast recursive algorithm to reverse the list
    public void reverseRec() {
        head = reverseRecHelper(head);
    }

    public void insertionSort() {
        Node<Integer> current = (Node<Integer>)head;
        Node<Integer> tail = null;
        while(current != null && tail != head) {
          Node<Integer> next = current;
          while(next.next != tail) {
            if(next.getElement() <= next.next.getElement()) {
              int temp = next.getElement();
              next.setElement(next.next.getElement());
              next.next.setElement(temp);
            }
            next = next.next;
          }
          tail = next;
          current = (Node<Integer>)head;
        }
    }

    public void increment() {
        Node<Integer> cur = (Node<Integer>)head;
        while(cur != null) {
            cur.setElement(cur.getElement() + 1);
            cur = cur.next;
        }
    }
    
    public static void increment2D(SLL<SLL<Integer>> list) {
        for(int i = 0; i < list.size(); i++) {
            list.getAt(i).increment();
        }
    }
}