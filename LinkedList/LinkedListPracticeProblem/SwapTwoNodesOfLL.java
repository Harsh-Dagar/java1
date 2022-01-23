package LinkedList.LinkedListPracticeProblem;
import LinkedList.*;

public class SwapTwoNodesOfLL {
    private static Node<Integer> returnNodeAtIndexI(Node<Integer>head,int i){
        if(i==0){
            return head;
        }
        Node<Integer>temp=head;
        int pos=0;
        while(pos!=i&&temp!=null){
            temp=temp.next;
            pos++;
        }
        return temp;
    }
    public static Node<Integer> swapNodes(Node<Integer>head,int i,int j){
        if(head==null||head.next==null||i==j){
            return head;
        }
        if(i==0||j==0){
            if(j==1||i==1){
                Node<Integer>temp=head.next.next;
                Node<Integer>x=head;
                Node<Integer>y=head.next;
                head=y;
                y.next=x;
                x.next=temp;
            }
            else{
                if(j==0){
                    j=i;
                    i=0;
                }
                Node<Integer>temp1=head;
                Node<Integer>temp1Next=head.next;
                Node<Integer>temp2=returnNodeAtIndexI(head,j);
                Node<Integer>temp2prev=returnNodeAtIndexI(head,j-1);
                Node<Integer>temp2Next=returnNodeAtIndexI(head,j+1);
                head=temp2;
    
                temp2prev.next=temp1;
                temp1.next=temp2Next;
                temp2.next=temp1Next;  
            }
        }
        else if(i==j+1||j==i+1){
            int index=0;
            if(i>j){
                index=j;
            }
            else{
                index=i;
            }
            Node<Integer> x=returnNodeAtIndexI(head,index);
            Node<Integer> xPrev=returnNodeAtIndexI(head, index-1);
            Node<Integer> y=returnNodeAtIndexI(head,index+1);
            Node<Integer> yNext=returnNodeAtIndexI(head, index+2);
            xPrev.next=y;
            x.next=yNext;
            y.next=x;
        }
        else{

            Node<Integer>t1=returnNodeAtIndexI(head, i);
            Node<Integer>t1Prev=returnNodeAtIndexI(head, i-1);
            Node<Integer>t1Next=returnNodeAtIndexI(head, i+1);
            Node<Integer>t2=returnNodeAtIndexI(head, j);
            Node<Integer>t2Prev=returnNodeAtIndexI(head, j-1);
            Node<Integer>t2Next=returnNodeAtIndexI(head, j+1);

            t1Prev.next=t2;
            t2Prev.next=t1;
            t1.next=t2Next;
            t2.next=t1Next;
        }
        return head;
    } 
    public static void main(String[] args) {
        Node<Integer> head=LinkedListUse.takeInput();
        LinkedListUse.print(swapNodes(head, 1,2));
    } 
}
