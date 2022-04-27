package Tries;

public class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode child[];
    int childCount=0;
    public TrieNode(char data){
        this.data=data;
        this.isTerminating=false;
        child=new TrieNode[26]; 
        this.childCount=0;
    }
}
