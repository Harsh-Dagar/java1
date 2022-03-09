package BinaryTree.BinaryTreeQuestions;

import BinaryTree.BinaryTreeNode;

public class NodeWithoutSibling {
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer>root){
        if(root==null){
            return;
        }
        if(root.left!=null&&root.right==null){
            System.out.print(root.left.data+" ");
        }
        else if(root.left==null&&root.right!=null){
            System.out.print(root.right.data+" ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }
}
