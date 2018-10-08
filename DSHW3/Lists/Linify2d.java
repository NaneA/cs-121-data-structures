public class Linify2d {

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> down;

        public Node(E element) {
            this.element = element;
        }

        public Node() {}
    }

    private static Node<Integer> merge(Node<Integer> first, Node<Integer> second) {
        Node<Integer> head = new Node<Integer>();
        Node<Integer> temp = head;
        while (first != null && second != null) {
            if (first.element < second.element) {
                temp.down = first;
                temp = temp.down;
                first = first.down;
            } else if (second.element < first.element) {
                temp.down = second;
                temp = temp.down;
                second = second.down;
            }
        }

        temp.down = (first == null) ? second : first;
        return head.down;
    }

    private static Node<Integer> linify(Node<Integer> root) {

        Node<Integer> temp = root;
        Node<Integer> result = null;
        while (temp != null) {
            result = merge(temp, result);
            temp = temp.next;
        }
        return result;
    }

    public static void print(Node<Integer> node) {
        while (node != null) {
            System.out.println(node.element);
            node = node.down;
        }
    }

    public static void main(String[] args) {
        Node<Integer> h1 = new Node<Integer>(3);
        h1.next = new Node<Integer>(8);
        h1.next.next = new Node<Integer>(15);
        h1.next.next.next = new Node<Integer>(20);
        h1.down = new Node<Integer>(6);
        h1.down.down = new Node<Integer>(7);
        h1.down.down.down = new Node<Integer>(11);
        h1.next.down = new Node<Integer>(12);
        h1.next.down.down = new Node<Integer>(25);
        h1.next.next.down = new Node<Integer>(23);
        h1.next.next.next.down = new Node<Integer>(21);
        h1.next.next.next.down.down = new Node<Integer>(22);
        Node<Integer> result = linify(h1);
        print(result);
    }
}