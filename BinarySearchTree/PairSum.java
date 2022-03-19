package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class PairSum {

    private static boolean findNode(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            // root.data=Integer.MAX_VALUE;

            return true;
        }
        boolean ans = findNode(root.left, x);
        if (ans == true) {
            return ans;
        }
        ans = findNode(root.right, x);
        return ans;
    }

    private static void pairSum(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> currentNode, int s) {
        if (root == null || currentNode == null) {
            return;
        }
        if (currentNode.data != Integer.MAX_VALUE) {
            if (findNode(root, s - currentNode.data)) {
                if (currentNode.data > s - currentNode.data) {
                    System.out.println((s - currentNode.data) + " " + currentNode.data);
                }
                if (currentNode.data < s - currentNode.data) {
                    System.out.println(currentNode.data + " " + (s - currentNode.data));

                }
                currentNode.data = Integer.MIN_VALUE;
            }
        }
        pairSum(root, currentNode.right, s);

        pairSum(root, currentNode.left, s);

    }

    public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
        pairSum(root, root, sum);
    }
}
