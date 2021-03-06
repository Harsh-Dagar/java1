package BinarySearchTree;

import java.util.ArrayList;

import BinaryTree.BinaryTreeNode;

public class FindPathInBST {
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root,int data){
        if(root==null){
            return null;
        }
        if(root.data==data){
            ArrayList<Integer> output=new ArrayList<>();
            output.add(data);
            return output;
        }
        if(data<root.data){
            ArrayList<Integer> leftOutput=getPath(root.left, data);
            if(leftOutput!=null){
                leftOutput.add(root.data);
                return leftOutput;
            }
            else{
                return null;
            }
        }
        else{
            ArrayList<Integer> rightOutput=getPath(root.right, data);
            if(rightOutput!=null){
                rightOutput.add(root.data);
                return rightOutput;
            }
            else{
                return null;
            }
        }
    }
}
