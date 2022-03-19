package BinaryTree.BinaryTreeQuestions;

import BinaryTree.BinaryTreeNode;
/*
For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
Return the output as an object of Pair class, which is already created.
*/

class Pair <T,V>{
    T minimum;
    V maximum;
    public Pair(T minimum,V maximum){
        this.minimum=minimum;
        this.maximum=maximum;
    }
}


public class MinAndMaxNode {

    public static Pair<Integer,Integer> getMinAndMax(BinaryTreeNode<Integer> root){
        if(root==null){
            Pair<Integer,Integer> output=new Pair<>(Integer.MAX_VALUE,Integer.MAX_VALUE);
            return output;
        }
        Pair<Integer,Integer> leftAns=getMinAndMax(root.left);
        Pair<Integer,Integer> rightAns=getMinAndMax(root.right);
        int max=Math.max(root.data,Math.max(leftAns.maximum, rightAns.maximum));
        int min=(root.data<leftAns.minimum&&root.data<rightAns.minimum)?root.data:(leftAns.minimum<rightAns.minimum?leftAns.minimum:rightAns.minimum);
        Pair<Integer,Integer> output=new Pair<>(min, max);
        return output;


    }

    
}
