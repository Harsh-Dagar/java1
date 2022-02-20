package Trees.TreesPracticeQuestion;

import Trees.*;

public class DepthOfNode {
    public static void printAtK(TreeNode<Integer> root,int k){
        if(k<0){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
            return;
        }
        for(int i=0;i<root.children.size();i++){
            printAtK(root.children.get(i), k-1);
        }
    }   
}
