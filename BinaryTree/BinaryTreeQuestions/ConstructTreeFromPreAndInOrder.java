package BinaryTree.BinaryTreeQuestions;

import BinaryTree.BinaryTreeNode;

public class ConstructTreeFromPreAndInOrder {
    private static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder, int inStart, int inEnd,
            int preStart, int preEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int r=preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(r);
        int rootInIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == r) {
                rootInIndex = i;
                break;
            }
        }
        if(rootInIndex==-1){
            return null;
        }
        int leftInS = inStart;
        int leftInE = rootInIndex - 1;
        int leftPreS = preStart + 1;
        int leftPreE = leftPreS + (leftInE - leftInS);
        int rightInS = rootInIndex + 1;
        int rightInE = inEnd;
        int rightPreS = leftPreE + 1;
        int rightPreE = preEnd;

        BinaryTreeNode<Integer> left = buildTree(preOrder, inOrder, leftInS, leftInE, leftPreS, leftPreE);
        BinaryTreeNode<Integer> right = buildTree(preOrder, inOrder, rightInS, rightInE, rightPreS, rightPreE);
        root.left = left;
        root.right = right;
        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        return buildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, preOrder.length - 1);
    }
}
