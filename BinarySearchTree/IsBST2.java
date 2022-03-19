package BinarySearchTree;

import BinaryTree.BinaryTreeNode;
import BinaryTree.Pair;

public class IsBST2 {
    private static Pair<Pair<Integer, Integer>, Boolean> isBSTHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Pair<Integer, Integer>, Boolean> output = new Pair<>(
                    new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE), true);
            return output;
        }
        Pair<Pair<Integer, Integer>, Boolean> left = isBSTHelper(root.left);
        Pair<Pair<Integer, Integer>, Boolean> right = isBSTHelper(root.right);
        int min = Math.min(root.data, Math.min(left.first.first, right.first.first));
        int max = Math.max(root.data, Math.max(left.first.second, right.first.second));
        boolean isBSTHelper = (root.data > left.first.second) && (root.data <= right.first.first) && left.second
                && right.second;
        Pair<Pair<Integer, Integer>, Boolean> output = new Pair<>(new Pair<Integer, Integer>(min, max), isBSTHelper);
        return output;
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        Pair<Pair<Integer, Integer>, Boolean> output = isBSTHelper(root);
        return output.second;
    }
}

