package Trees.TreesPracticeQuestion;

import Trees.TreeNode;

public class CountLeafNode {
    public static int countLeafNode(TreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int ans=0;
        if(root.children.size()==0){
            ans++;
        }
        for(int i=0;i<root.children.size();i++){
            ans+=countLeafNode(root.children.get(i));
        }
        return ans;
     }
    
}
