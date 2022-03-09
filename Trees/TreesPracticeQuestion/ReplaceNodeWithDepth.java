package Trees.TreesPracticeQuestion;

import Trees.TreeNode;

public class ReplaceNodeWithDepth {
    private static void replaceWithDepthValue(TreeNode<Integer> root,int k){
		if(root==null){
            return;
        }
        root.data=k;
        for(int i=0;i<root.children.size();i++){
            replaceWithDepthValue(root.children.get(i), k+1);
        }
	}
    public static void replaceWithDepthValue(TreeNode<Integer> root){
        replaceWithDepthValue(root,0);
    }
}
