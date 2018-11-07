import utils.*;

import java.util.LinkedList;

public class Ex6 {
    public static <E> void print(E item) {
        System.out.println(item);
    }

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<Integer>();

        //root
        t.addRoot(1);

        //level 2
        t.addLeft(t.root(), 2);
        t.addRight(t.root(), 3);

        //level 3
        t.addLeft(t.left(t.root()), 4);
        t.addRight(t.left(t.root()), 5);
        t.addLeft(t.right(t.root()), 6);
        t.addRight(t.right(t.root()), 7);

        //level 4
        t.addLeft(t.left(t.left(t.root())), 8);
        t.addRight(t.left(t.left(t.root())), 9);
        t.addRight(t.right(t.left(t.root())), 10);
        t.addRight(t.right(t.right(t.root())), 11);

        //level 5
        t.addLeft(t.left(t.left(t.left(t.root()))), 12);
        t.addRight(t.left(t.left(t.left(t.root()))), 13);
        t.addLeft(t.right(t.left(t.left(t.root()))), 14);
        t.addRight(t.right(t.right(t.left(t.root()))), 15);
        t.addRight(t.right(t.right(t.right(t.root()))), 16);

        //level 6
        t.addLeft(t.left(t.left(t.left(t.left((t.root()))))), 17);
        t.addRight(t.left(t.left(t.left(t.left((t.root()))))), 18);
        t.addRight(t.left(t.right(t.left(t.left((t.root()))))), 19);
        t.addLeft(t.right(t.right(t.right(t.right(t.root())))), 20);
        t.addRight(t.right(t.right(t.right(t.right(t.root())))), 21);

        //level 7
        t.addLeft(t.left(t.left(t.left(t.left(t.left((t.root())))))), 22);
        t.addRight(t.left(t.left(t.left(t.left(t.left((t.root())))))), 23);
        t.addRight(t.left(t.right(t.right(t.right(t.right((t.root())))))), 24);
        t.addRight(t.right(t.right(t.right(t.right(t.right(t.root()))))), 25);

        //հույս ունեմ՝ աջն ու ձախը ոչ մի տեղ չեմ խառնել :'(

        LinkedList<Position<Integer>> L = new LinkedList<>();
        Roman(t, t.root(), L);
        for(Position<Integer> x : L) {
            print(x.getElement());
        }
    }

    static void Roman(LinkedBinaryTree<Integer> tree, Position<Integer> root, LinkedList<Position<Integer>> list) {
        if(root == null) {
            return;
        } // base case

        /*
            We have to update the size parameter. Let's use the fact that d(root) = d(r) + 1 + d(l) + 1
         */
        Roman(tree, tree.left(root), list);
        if(tree.left(root) != null) {
            root.setSize(root.size() + 1 + tree.left(root).size());
        }
        Roman(tree, tree.right(root), list);
        if(tree.right(root) != null) {
            root.setSize(root.size() + 1 + tree.right(root).size());
        }

        //for simplicity, we will assume that null nodes have 0 child
        int leftSz = (tree.left(root) == null ? 0 : tree.left(root).size());
        int rightSz = (tree.right(root) == null ? 0 : tree.right(root).size());

        if(Math.abs(leftSz - rightSz) < 5) {
            root.setRoman(true);
        } else {
            root.setRoman(false);
        }
        //nodes are updated now!


        boolean leftIsRom = tree.left(root) == null || tree.left(root).isRoman();
        boolean rightIsRom = tree.right(root) == null || tree.right(root).isRoman();

        if(Math.abs(leftSz - rightSz) >= 5 && leftIsRom && rightIsRom) {
            list.addFirst(root);
        }
    }
}