package BinaryTree;

import java.util.Scanner;


import Queue.QueueEmptyException;
import Queue.QueueUsingLinkedList;

public class BInaryTreeUse {

    public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
        int rootData;
        System.out.println("Enter root data:");
        rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        root.left = takeInput(sc);
        root.right = takeInput(sc);
        return root;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        QueueUsingLinkedList<BinaryTreeNode<Integer>> pendingNode = new QueueUsingLinkedList<>();
        System.out.print("Enter data of root: ");

        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        pendingNode.enqueue(root);
        while (!pendingNode.isEmpty()) {
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNode.dequeue();

            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.print("Enter left child of " + front.data + ": ");
            int leftChild = sc.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftChild);
                front.left = left;
                pendingNode.enqueue(left);
            } 
            System.out.print("Enter right child of "+front.data+": ");
            int rightChild=sc.nextInt();
            if(rightChild!=-1){
                BinaryTreeNode<Integer>right=new BinaryTreeNode<>(rightChild);
                front.right=right;
                pendingNode.enqueue(right);
            } 
        }
        return root;
    }

    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String toBePrinted = root.data + ": ";
        if (root.left != null) {
            toBePrinted += "L" + root.left.data + ",";
        }
        if (root.right != null) {
            toBePrinted += "R" + root.right.data;
        }
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        QueueUsingLinkedList<BinaryTreeNode<Integer>> pendingNode=new QueueUsingLinkedList<>();
        pendingNode.enqueue(root);
        while(!pendingNode.isEmpty()){
            BinaryTreeNode<Integer>front;
            try{
                front=pendingNode.dequeue();
            }
            catch(QueueEmptyException e){
                return;
            }
            System.out.print(front.data+":");
            
            if(front.left!=null){
                System.out.print("L:"+front.left.data+",");
                pendingNode.enqueue(front.left);
            } 
            if(front.right!=null){
                System.out.print("R:"+front.right.data);
                pendingNode.enqueue(front.right);
            }  
            System.out.println();             
        }     
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
    }
}
