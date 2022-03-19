package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class BinarySearchTree {
    private BinaryTreeNode<Integer> root;

    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            BinaryTreeNode<Integer> output = new BinaryTreeNode<>(data);
            return output;
        }
        if (root.data >= data) {
            BinaryTreeNode<Integer> leftOutput = insertHelper(root.left, data);
            root.left = leftOutput;
            return root;
        } else {
            BinaryTreeNode<Integer> rightOutput = insertHelper(root.right, data);
            root.right = rightOutput;
            return root;
        }
    }

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    private BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data > data) {
            root.left = deleteHelper(root.left, data);
            return root;
        } else if (root.data < data) {
            root.right = deleteHelper(root.right, data);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = deleteHelper(root.right, minNode.data);
                return root;
            }

        }

    }

    public void remove(int data) {
        root = deleteHelper(root, data);
    }

    private static boolean hasDataHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (root.data >= data) {
            return hasDataHelper(root.left, data);
        } else {
            return hasDataHelper(root.right, data);
        }
    }

    public boolean search(int data) {
        return hasDataHelper(root, data);
    }

    private void printHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+":");
        
        if (root.left != null) {
            System.out.print("L:"+root.left.data+",");
            
        }
        if (root.right != null) {
            System.out.print("R:"+root.right.data);
            
        }
        System.out.println();
        printHelper(root.left);
        printHelper(root.right);

    }

    public void printTree() {
        printHelper(root);
    }

}
