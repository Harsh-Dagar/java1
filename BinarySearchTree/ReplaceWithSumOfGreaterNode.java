package BinarySearchTree;


import BinaryTree.BinaryTreeNode;

public class ReplaceWithSumOfGreaterNode {
    private static int helper(BinaryTreeNode<Integer> root,int sum){
        if(root==null){
            return sum;
        }
        sum=helper(root.right, sum);
        sum+=root.data;
        root.data=sum;
        sum=helper(root.left, sum);
        return sum;
    }
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root){
        helper(root, 0);
    }
}
