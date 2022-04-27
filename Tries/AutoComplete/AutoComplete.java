package Tries.AutoComplete;

import java.util.ArrayList;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount = 0;
    }
}

class Trie {
    TrieNode root;
    public int count;

    public Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    public TrieNode findWord(TrieNode input, String word) {
        for (int i = 0; i < word.length(); i++) {
            int childIndex = word.charAt(i) - 'a';
            TrieNode child = input.children[childIndex];
            if (child == null) {
                return null;
            } else {
                input = child;
            }
        }
        return input;
    }

    public void printAll(TrieNode root,String word,String outputSoFar){
        if(root.isTerminating){
            System.out.println(word+outputSoFar);
        }
        if(root.childCount==0){
            if(outputSoFar.length()>0){
                System.out.println(word+outputSoFar);
            }
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                printAll(root.children[i], word, outputSoFar+root.children[i].data);
            }
        }
    }


    public void autoComplete(ArrayList<String> input, String word) {

        // Write your code here
        for(String s:input){
            add(s);
        }
        TrieNode tn=findWord(root, word);
        if(tn==null||tn.childCount==0){
            return;
        }
        printAll(tn, word, "");


    }

}