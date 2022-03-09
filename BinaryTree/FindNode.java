package BinaryTree;

public class FindNode {
    public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        boolean ans=isNodePresent(root.left, x);
        if(ans==true){
            return ans;
        }
        ans=isNodePresent(root.right, x);
        return ans;
    }
    
}
