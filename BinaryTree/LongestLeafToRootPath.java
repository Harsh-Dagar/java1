package BinaryTree;


import java.util.ArrayList;

public class LongestLeafToRootPath {
    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
        if(root==null){
            ArrayList<Integer> output=new ArrayList<>();
            return output;
        }
        ArrayList<Integer> leftOutput=longestRootToLeafPath(root.left);
        ArrayList<Integer> rightOutput=longestRootToLeafPath(root.right);
        ArrayList<Integer> output=new ArrayList<Integer>();
        if(leftOutput.size()>rightOutput.size()){
            output.addAll(leftOutput);
        }
        else{
            output.addAll(rightOutput);
        }
        output.add(root.data);

        return output;
    }
}
