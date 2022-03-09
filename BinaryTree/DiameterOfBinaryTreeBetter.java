package BinaryTree;


class Pair<T,V>{
    public T first;
    public V second;
}

public class DiameterOfBinaryTreeBetter {
    private static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer> root){
        if(root==null){
            Pair<Integer,Integer> output=new Pair<>();
            output.first=0;
            output.second=0;
            return output;
        }
        Pair<Integer,Integer> lo=heightDiameter(root.left);
        Pair<Integer,Integer> ro=heightDiameter(root.right);
        int height=1+Math.max(lo.first, ro.first);
        int o1=lo.first+ro.first;
        int o2=lo.second;
        int o3=ro.second;
        Pair<Integer,Integer> output=new Pair<>();
        output.first=height;
        output.second=((o1>o2)&&o1>o3?o1:((o2>o3)?o2:o3));
        return output;
    }
    public static int diameter(BinaryTreeNode<Integer>root){
        Pair<Integer,Integer> output=heightDiameter(root);
        int d=output.second;
        return d;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root=BInaryTreeUse.takeInputLevelWise();
        System.out.println(diameter(root));
        

    }
}
