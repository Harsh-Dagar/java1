package BinaryTree.BinaryTreeQuestions; 

import BinaryTree.BinaryTreeNode;


public class PrintNodesAtDistKFromNode {

    private static void print(BinaryTreeNode<Integer> root,int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.println(root.data);
            return;
        }
        print(root.left, k-1);
        print(root.right, k-1);
    }
    private static int printHelper(BinaryTreeNode<Integer> root,int node,int k){
        if(root==null){
            return -1;
        }
        if(root.data==node){
            print(root,k);
            return 0;
        }
        int ld=printHelper(root.left, node, k);
        if(ld!=-1){
            if(ld+1==k){
                System.out.println(root.data);
            }
            else{
                print(root.right, k-ld-2);
            }
            return ld+1;
        }
        int rd=printHelper(root.right, node, k);
        if(rd!=-1){
            if(rd+1==k){
                System.out.println(root.data);
            }
            else{
                print(root.left, k-rd-2);
            }
            return rd+1;
        }
        return -1;
    } 
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root,int node,int k){
        printHelper(root, node, k);
    }
     
}
