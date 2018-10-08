package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SLL2D<E> {
    public static class Node<E> {
        private E element;
        private Node<E> next;
        private SLL.Node<E> down;

        public Node(E e, Node<E> n,  SLL.Node<E> d) {
            element = e;
            next = n;
            down = d;
        }
        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public SLL.Node<E> getDown() {
        	return down;
        }
        private void setNext(Node<E> node) {
            next = node;
        }

        private void setElement(E e) {
            element = e;
        }
    }

    private int size;

    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
    	return size;
    }

    public SLL2D() {}

    public SLL2D(E[] arr, List lists) {
    	this();
    	if(arr.length == lists.size()) {
	    	for(int i = 0; i < arr.length; i++) {
	    		addFirst(arr[i], ((SLL<E>)lists.get(i)).head);
	    	}
    	}
    }

    public E first() {
        if(!isEmpty()) {
            return head.getElement();
        }
        return null;
    }

    public SLL.Node<E> firstHead() {
        if(!isEmpty()) {
            return head.getDown();
        }
        return null;
    }

    public E last() {
        if(!isEmpty()) {
            return tail.getElement();
        }
        return null;
    }

    public SLL.Node<E> lastHead() {
        if(!isEmpty()) {
            return tail.getDown();
        }
        return null;
    }

    public void addFirst(E el, SLL.Node<E> d) {
        head = new Node<>(el, head, d);
        if(isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E el, SLL.Node<E> d) {
        Node<E> newest = new Node<E>(el, null, d);
        if(isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
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

    public SLL.Node<E> linify() {
    	SLL<E> result = new SLL<E>();
    	
    }
}