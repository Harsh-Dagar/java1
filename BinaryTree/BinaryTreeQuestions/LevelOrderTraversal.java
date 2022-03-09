package BinaryTree.BinaryTreeQuestions;
import Queue.*;
/*
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line. Elements on every level will be printed in a linear fashion and a single space will separate them.*/

import BinaryTree.BinaryTreeNode;


public class LevelOrderTraversal {
    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }

        QueueUsingLinkedList<BinaryTreeNode<Integer>>pendingNodes=new QueueUsingLinkedList<>();
        BinaryTreeNode<Integer> nullNode=new BinaryTreeNode<Integer>(Integer.MIN_VALUE);
        pendingNodes.enqueue(root);
        pendingNodes.enqueue(nullNode);
        System.out.println(root.data);
        while(pendingNodes.size()>1){
            BinaryTreeNode<Integer> front=null;
            try{
                front=pendingNodes.dequeue();
            }
            catch(QueueEmptyException e){}
            if(front==nullNode){
                pendingNodes.enqueue(nullNode);
                System.out.println();
                continue;
            }
            if(front.left!=null){
                pendingNodes.enqueue(front.left);
                System.out.print(front.left.data+" ");
            }
            if(front.right!=null){
                pendingNodes.enqueue(front.right);
                System.out.print(front.right.data+" ");
            }
            
        }
        
    }
}
