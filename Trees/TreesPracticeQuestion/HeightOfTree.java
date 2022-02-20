package Trees.TreesPracticeQuestion;
import Trees.TreeNode;

public class HeightOfTree {
    public static int getHeight(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int height=1;
        int maxSubTreeHeight=0;
        for(int i=0;i<root.children.size();i++){
            int a=getHeight(root.children.get(i));
            if(maxSubTreeHeight<a){
                maxSubTreeHeight=a;
            }
        }
        height+=maxSubTreeHeight;
        return height;
    }
}
