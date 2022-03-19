package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

public class ConstructBTSFromSortedArray {
    private static BinaryTreeNode<Integer> sortedArrayToBTS(int[] arr, int si, int ei) {
        if(si>ei){
            return null;
        }
        int mid=si+(ei-si)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(arr[mid]);
        BinaryTreeNode<Integer> left=sortedArrayToBTS(arr, si,mid-1);
        BinaryTreeNode<Integer> right=sortedArrayToBTS(arr, mid+1,ei);
        root.left=left;
        root.right=right;
        return root;
    }

    public static BinaryTreeNode<Integer> sortedArrayToBTS(int[] arr, int n) {
        return sortedArrayToBTS(arr, 0, n-1);
    }
}
