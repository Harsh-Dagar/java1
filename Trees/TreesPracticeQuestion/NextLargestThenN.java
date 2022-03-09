package Trees.TreesPracticeQuestion;

import Trees.TreeNode;

public class NextLargestThenN {
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		// Write your code here
        if(root==null){
            return null;
        }
        TreeNode<Integer> ans=null;
        if(root.data>n){
            ans=root;
        }
        for(int i=0;i<root.children.size();i++){
            TreeNode<Integer>temp=findNextLargerNode(root.children.get(i), n);
            if(temp!=null&&ans==null){
                ans=temp;
            }
            else if(temp!=null&&ans.data>temp.data){
                ans=temp;
            }
        }
        return ans;


	}
}
