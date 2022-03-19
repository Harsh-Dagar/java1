package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class CheckIfTreeIsBST {
    private static int maxNode(BinaryTreeNode<Integer> root){
        if(root ==null){
            return Integer.MIN_VALUE;
        }
        int leftMax=maxNode(root.left);
        int rightMax=maxNode(root.right);
        return Math.max(root.data,Math.max(leftMax,rightMax));
    }
    private static int minNode(BinaryTreeNode<Integer> root){
        if(root ==null){
            return Integer.MAX_VALUE;
        }
        int leftMin=minNode(root.left);
        int rightMin=minNode(root.right);
        return Math.min(root.data,Math.min(leftMin, rightMin));
    }
    public static boolean isBST(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }
        int leftMax=maxNode(root.left);
        int rightMin=minNode(root.right);
        if(leftMax>=root.data||rightMin<=root.data){
            return false;
        }
        boolean ans1=isBST(root.left);
        boolean ans2=isBST(root.right);
        if(ans1&&ans2){
            return true;
        }
        else{
            return false;
        }
    }
}
