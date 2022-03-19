package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class GetLCA {
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null) {
            return -1;
        }
        if (root.data == a || root.data == b) {
            return root.data;
        }
        if (root.data > a && root.data > b) {
            return getLCA(root.left, a, b);
        } else if (root.data < a && root.data < b) {
            return getLCA(root.right, a, b);
        }

        int leftAns = getLCA(root.left, a, b);
        int rightAns = getLCA(root.right, a, b);
        if (leftAns == -1 && rightAns == -1) {
            return -1;
        } else if (leftAns != -1 && rightAns != -1) {
            return root.data;
        } else if (rightAns == -1) {
            return leftAns;
        } else {
            return rightAns;
        }

    }
}
