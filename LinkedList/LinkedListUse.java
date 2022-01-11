package LinkedList;
import java.util.Scanner;

public class LinkedListUse {
    public static void print(Node<Integer> head){
        Node<Integer>temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    //takeInput() will take input until he give -1 as input

      //Time Complexity-> O(n)
    public static Node<Integer> takeInput(){
        Node<Integer> head=null;
        Node<Integer> tail=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while(data!=-1){
            Node<Integer>newNode=new Node<>(data);
            if(head==null){
               head=newNode;  
               tail=newNode;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
            data=sc.nextInt();
        }
        sc.close();
        return head;
    }   
    public static int length(Node<Integer>head){
        Node<Integer>temp=head;
        int ans=0;
        while(temp!=null){
            ans++;
            temp=temp.next;
        }
        return ans;
    }
    public static void printIthNode(Node<Integer>head,int i){
        Node<Integer>temp=head;
        if(head==null){
            return;
        }
        for(int index=0;index<=i;index++){
            if(temp.next==null){
                return;
            }
            temp=temp.next;
        }
        System.out.println(temp.data);
    }
    public static Node<Integer> insert(Node<Integer>head,int data,int pos){
        Node<Integer>newNode=new Node<>(data);
        Node<Integer>temp=head;
        if(pos==0){
            newNode.next=head;
            return newNode;
        }
        for(int i=1;i<pos;i++){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
    public static Node<Integer> deleteNode(Node<Integer>head,int pos){
        Node<Integer>temp=head;
        if(pos==0){
            head=head.next;
            return head;
        }
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
            if(temp.next==null){
                return head;
            }
        }
        temp.next=temp.next.next;
        return head;

    }
}
