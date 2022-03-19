package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class isBST3 {
    public static boolean isBST(BinaryTreeNode<Integer> root,int min,int max){
        if(root==null){
            return true;
        }
        if(root.data<min||root.data>max){
            return false;
        }
        boolean isLeftBST=isBST(root.left,min,root.data-1);
        boolean isRightBST=isBST(root.right, root.data, max);
        return (isLeftBST&&isRightBST);
    }
}
