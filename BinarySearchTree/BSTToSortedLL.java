package BinarySearchTree;


import BinaryTree.BinaryTreeNode;
import LinkedList.Node;
class HeadTailOfLL{
    Node<Integer> head;
    Node<Integer>  tail;
    HeadTailOfLL(Node<Integer> head,Node<Integer> tail){
        this.tail=tail;
        this.head=head;
    }
}

public class BSTToSortedLL {
    private static HeadTailOfLL helper(BinaryTreeNode<Integer> root) {
        if(root==null){
            HeadTailOfLL output=new HeadTailOfLL(null, null);
            return output;
        }
        HeadTailOfLL left=helper(root.left);
        Node<Integer> rootNode=new Node<>(root.data);
        if(left.tail!=null){
            left.tail.next=rootNode;
        }
        else{
            left.head=rootNode;
        }
        HeadTailOfLL right=helper(root.right);
        if(right.head!=null){
            rootNode.next=right.head;
        }
        else{
            rootNode.next=null;
        }
        HeadTailOfLL output;
        if(right.head!=null){
            output=new HeadTailOfLL(left.head,right.tail);
        }
        else{
            output=new HeadTailOfLL(left.head,rootNode);
        }
        return output;
    }
    public static Node<Integer> constructLinkedList(BinaryTreeNode<Integer> root){
        HeadTailOfLL output=helper(root);
        return output.head;
    }
}
