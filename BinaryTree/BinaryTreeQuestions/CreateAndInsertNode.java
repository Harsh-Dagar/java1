package BinaryTree.BinaryTreeQuestions;
import BinaryTree.*;
/*
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.
*/

public class CreateAndInsertNode {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTreeNode<Integer> rootDuplicate=new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> leftNode=root.left;
        root.left=rootDuplicate;
        root.left.left=leftNode;
    }
    
}
