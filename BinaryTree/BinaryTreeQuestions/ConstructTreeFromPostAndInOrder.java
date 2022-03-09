package BinaryTree.BinaryTreeQuestions;

import BinaryTree.BinaryTreeNode;

public class ConstructTreeFromPostAndInOrder {
    private static BinaryTreeNode<Integer> buildTree(int []postOrder,int []inOrder,int postStart,int postEnd,int inStart,int inEnd){
        if(inStart>inEnd){
            return null;
        }
        int r=postOrder[postEnd];
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
        int leftInS=inStart;
        int leftInE=rootInIndex-1;
        int leftPostS=postStart;
        int leftPostE=(leftInE-leftInS)+leftPostS;
        int rightInS=rootInIndex+1;
        int rightInE=inEnd;
        int rightPostS=leftPostE+1;
        int rightPostE=postEnd-1;
       
        BinaryTreeNode<Integer> left = buildTree(postOrder, inOrder, leftPostS, leftPostE, leftInS, leftInE);
        BinaryTreeNode<Integer> right = buildTree(postOrder, inOrder, rightPostS, rightPostE, rightInS, rightInE);
        root.left = left;
        root.right = right;
        return root;
        
        
    }
    public static BinaryTreeNode<Integer> buildTree(int []postOrder,int [] inOrder){
        return buildTree(postOrder, inOrder,0,postOrder.length-1,0,inOrder.length-1);
    }
}
