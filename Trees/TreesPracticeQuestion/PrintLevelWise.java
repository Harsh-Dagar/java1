package Trees.TreesPracticeQuestion;
import Trees.*;

import Queue.*;

public class PrintLevelWise {
    public static void printLevelWise(TreeNode<Integer> root){
        if(root==null){
            return;
        }
        QueueUsingLinkedList<TreeNode<Integer>> q=new QueueUsingLinkedList<>();
        TreeNode<Integer> nullNode=new TreeNode<Integer>(Integer.MIN_VALUE);
        System.out.println(root.data);
        while(q.size()!=1){
            TreeNode<Integer> temp=null;
            try{
                temp=q.dequeue();
            }catch(QueueEmptyException e){}
            if(temp==nullNode){
                q.enqueue(nullNode);
                System.out.println();
                continue;
            }
            for(int i=0;i<root.children.size();i++){
                System.out.print(temp.children.get(i).data+" ");
                q.enqueue(temp.children.get(i));
            }
        }
    }
    public static void main(String[] args) {
        TreeNode<Integer>root=TreeUse.takeInputLevelWise();
        printLevelWise(root);
    }
    
}
