import utils.*;

public class Ex1 {
    public static <E> void print(E item) {
        System.out.println(item);
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> L = new SinglyLinkedList<>();
        //9 -30 21 25 6 18
        L.addFirst(18);
//        L.addFirst(6);
//        L.addFirst(25);
//        L.addFirst(21);
//        L.addFirst(-30);
//        L.addFirst(9);
        for(Integer x : L) {
            print(x);
        }
    }
}
