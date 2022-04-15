package BinaryTree;


public class Cousins {
    private static int depthOfNode(BinaryTreeNode<Integer> root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left=depthOfNode(root.left, n);
        int right=depthOfNode(root.right, n);
        if(left!=-1){
            return left+1;
        }
        if(right!=-1){
            return right+1;
        }
        return -1;
    }
    private static boolean areSiblings(BinaryTreeNode<Integer> root,int n,int m){
        if(root==null){
            return false;
        }
        if(root.left==null||root.right==null){
            return false;
        }
        if((root.left.data==m&&root.right.data==n)||(root.left.data==n&&root.right.data==m)){
            return true;
        }
        boolean left=areSiblings(root.left, n, m);
        boolean right=areSiblings(root.right, n, m);
        return (left||right);
    }
    public static boolean isCousin(BinaryTreeNode<Integer> root,int p,int q){
        int depthP=depthOfNode(root, p);
        int depthQ=depthOfNode(root, q);
        if(depthP!=depthQ){
            return false;
        }
        if(areSiblings(root, p, q)){
            return false;
        }
        return true;
    }
}
