package Stack;

public class StackFullException extends Exception{
    @Override
    public String toString(){
        return "Stack is full";
    }
}
