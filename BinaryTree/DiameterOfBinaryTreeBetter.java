package BinaryTree;

class Pair{
    int a;
    int b;
    public Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
public class DiameterOfBinaryTreeBetter {
    private static Pair heightDiameter(BinaryTreeNode<Integer> root){
        if(root==null){
            Pair output=new Pair(0,0);
            return output;
        }
        Pair left=heightDiameter(root.left);
        Pair right=heightDiameter(root.right);
        int d3=left.a+right.a+1;
        int d=Math.max(left.b, Math.max(right.b,d3));
        int height=Math.max(left.a,right.a)+1;
        Pair output=new Pair(height,d);
        return output;
    }
    public static int diameter(BinaryTreeNode<Integer>root){
        Pair output=heightDiameter(root);
        int d=output.b;
        return d;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=BInaryTreeUse.takeInputLevelWise();
        System.out.println(diameter(root));
        

    }
}
