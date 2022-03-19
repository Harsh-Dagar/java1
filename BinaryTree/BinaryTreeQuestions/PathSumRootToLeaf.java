package BinaryTree.BinaryTreeQuestions;

import BinaryTree.*;

public class PathSumRootToLeaf {
    private static void helper(BinaryTreeNode<Integer> root, int k, String str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && k == (root.data)) {
            str = str + root.data;
            System.out.println(str);
            return;
        }
        int x = root.data;
        str = str + x + " ";
        helper(root.left, k - root.data, str);
        helper(root.right, k - root.data, str);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        helper(root, k, "");
    }

}
