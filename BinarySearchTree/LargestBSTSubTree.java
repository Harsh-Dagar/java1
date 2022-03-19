package BinarySearchTree;

import BinaryTree.BinaryTreeNode;

class Helper{
    public int min;
    public int max;
    public boolean isBST;
    public int height;
    Helper(int min,int max,boolean isBST,int height){
        this.max=max;
        this.min=min;
        this.isBST=isBST;
        this.height=height;
    }
}
public class LargestBSTSubTree {
    public static Helper helperFunt(BinaryTreeNode<Integer> root){
        if(root==null){
            Helper output=new Helper(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
            return output;
        }
        Helper leftOutput=helperFunt(root.left);
        Helper rightOutput=helperFunt(root.right);
        if(rightOutput.isBST==true&&leftOutput.isBST==true){
            if(leftOutput.max<root.data&&rightOutput.min>root.data){
                Helper output=new Helper(Math.min(root.data,leftOutput.min), Math.max(root.data, rightOutput.max),true, 1+Math.max(leftOutput.height, rightOutput.height));
                return output;
            }
            else{
                int min=Math.min(leftOutput.min,Math.min(root.data, rightOutput.min));
                int max=Math.max(rightOutput.max,Math.max(root.data, leftOutput.max));
                Helper output=new Helper(min, max, false, Math.max(leftOutput.height, rightOutput.height));
                return output;
            }
        }
        int max=Math.max(rightOutput.max,Math.max(root.data, leftOutput.max));
        int min=Math.min(leftOutput.min,Math.min(root.data, rightOutput.min));
        int height=Math.max(leftOutput.height, rightOutput.height);
        Helper output=new Helper(min, max, false, height);
        return output;

    }
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root){
        Helper output=helperFunt(root);
        return output.height;
    }
}
