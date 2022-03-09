package BinaryTree;

public class HeightOfTree {
    public static int height(BinaryTreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int h=1;
        int h1=height(root.left);
        int h2=height(root.right);
        if(h1>h2){
            h+=h1;
        }
        else{
            h+=h2;
        }
        return h;
    }
}
