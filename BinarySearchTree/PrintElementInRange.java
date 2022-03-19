package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class PrintElementInRange {
    public static void printElementInRangeK1K2(BinaryTreeNode<Integer>root,int k1,int k2){
        if(root==null){
            return;
        }
        printElementInRangeK1K2(root.left, k1, k2);
        if(root.data>=k1&&root.data<=k2){
            System.out.print(root.data+" ");
        }
        printElementInRangeK1K2(root.right, k1, k2);
        

    }
}
