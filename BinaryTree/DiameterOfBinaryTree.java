package BinaryTree;

public class DiameterOfBinaryTree {
    public static int diameter(BinaryTreeNode<Integer>root){
        if(root==null){
            return 0; 
        }
        int h1=HeightOfTree.height(root.left);
        int h2=HeightOfTree.height(root.right);
        int d=h1+h2;
        int d1=diameter(root.left);
        int d2=diameter(root.right);
        return (d>d1)&(d>d2)?d:(d1>d2?d1:d2);
    } 
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=BInaryTreeUse.takeInputLevelWise();
        System.out.println(diameter(root));
        
    }

}
