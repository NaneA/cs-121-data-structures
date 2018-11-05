import utils.*;
public class Ex6 {
    public static <E> void print(E item) {
        System.out.println(item);
    }
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<Integer>();

        //root
        t.addRoot(7);

        //level 2
        t.addLeft(t.root(), -4);
        t.addRight(t.root(), 23);

        //level 3
        t.addLeft(t.left(t.root()), 6);
        t.addRight(t.left(t.root()), 2);
        t.addRight(t.right(t.root()), 1);

        //level 4
        t.addLeft(t.left(t.left(t.root())), 0);
        t.addRight(t.left(t.left(t.root())), 3);
        t.addLeft(t.right(t.left(t.root())), 4);
        t.addRight(t.right(t.right(t.root())), -2);

        //level 5
        t.addRight(t.left(t.left(t.left(t.root()))), -1);

        print(t.numDescendants(t.root()));
    }
}
