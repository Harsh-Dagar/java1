package Queue.QueuePracticeQuestions;
import java.util.Queue;

public class RevFirstKElements {
    private static void rev(Queue<Integer>input,int x){
        if(input.size()<=x){
            return;
        }
        int t=input.poll();
        rev(input,x);
        input.add(t);

    }
    public static Queue<Integer> reverseKElements(Queue<Integer>input,int k){
        rev(input,input.size()-k);
        for(int i=0;i<input.size()-k;i++){
            input.add(input.remove());
        }
        return input;
    }
    
}
