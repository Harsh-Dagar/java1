package Trees.TreesPracticeQuestion;

import java.util.ArrayList;

import javax.swing.plaf.TreeUI;

import Trees.TreeNode;
import Trees.TreeUse;


public class StructurallyIdentical {
    private static ArrayList<Integer> returnArrayListOfTree(TreeNode<Integer> root,ArrayList<Integer>outputSoFar){
        if(root==null){
            ArrayList<Integer>ans=new ArrayList<>();
            return ans;
        }
        ArrayList<Integer> a=new ArrayList<>();
        outputSoFar.add(root.data);
        for(int i=0;i<root.children.size();i++){
            ArrayList<Integer> temp=returnArrayListOfTree(root.children.get(i), outputSoFar);
            for(int j=0;j<temp.size();i++){
                outputSoFar.add(temp.get(i));
            }
        }
        return outputSoFar;
    }
    static ArrayList<Integer> returnArrayListOfTree(TreeNode<Integer>root){
        ArrayList<Integer>a=new ArrayList<>();
        return returnArrayListOfTree(root,a);
    }
    // public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
    //     ArrayList<Integer> a1=returnArrayListOfTree(root1);

    // }
    public static void main(String[] args) {
        TreeNode<Integer> root=TreeUse.takeInputLevelWise();
        ArrayList<Integer>a=returnArrayListOfTree(root);
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
            
        }
    }
}
