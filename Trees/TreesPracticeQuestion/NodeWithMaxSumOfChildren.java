package Trees.TreesPracticeQuestion;

import Trees.TreeNode;

public class NodeWithMaxSumOfChildren {
    private static int sumOfNodeAndChildren(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int sum=root.data;
        for(int i=0;i<root.children.size();i++){
            sum+=root.children.get(i).data;
        }
        return sum;
    }
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        if (root == null) {
            return root;
        }
        int sumOfRootNode = sumOfNodeAndChildren(root);
        int maxSumOfSubTree=0;
        TreeNode<Integer> temp=null;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> smallAns=maxSumNode(root.children.get(i));
            int a=sumOfNodeAndChildren(smallAns);
            if(a>maxSumOfSubTree){
                maxSumOfSubTree=a;
                temp=smallAns;
            }
        }
        if(sumOfRootNode<maxSumOfSubTree){
            return temp;
        }
        return root;
    }

}
