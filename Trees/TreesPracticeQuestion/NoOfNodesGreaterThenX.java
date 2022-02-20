package Trees.TreesPracticeQuestion;
import Trees.TreeNode;

public class NoOfNodesGreaterThenX {
    public static int numNodeGreater(TreeNode<Integer> root,int x){
        int count=0;
        if(root.data>x){
            count=1;
        }
        for(int i=0;i<root.children.size();i++){
            count+=numNodeGreater(root.children.get(i), x);
        }
        return count;
    }
}
