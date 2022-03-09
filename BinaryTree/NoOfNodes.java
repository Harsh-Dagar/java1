package BinaryTree;

public class NoOfNodes {
    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        int count=1;
        count+=countNodes(root.left)+countNodes(root.right);
        return count;
    }
}
