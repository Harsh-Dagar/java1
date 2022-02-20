package Trees.TreesPracticeQuestion;
import Trees.TreeNode;

public class LargestNode {
    public static int largest(TreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int largest=root.data;
        for(int i=0;i<root.children.size();i++){
            int a=largest(root.children.get(i));
            if(a>largest){
                largest=a;
            }
        }
        return largest;
    }
    
}
