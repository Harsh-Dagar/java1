package Tries;

public class Trie {
    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');
        this.numWords = 0;
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.child[childIndex];

        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.child[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
        numWords++;
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminating;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.child[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean remove(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminating = false;
            return true;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.child[childIndex];
        if (child == null) {
            return false;
        }
        boolean ans = remove(child, word.substring(1));

        if (!child.isTerminating && child.childCount == 0) {
            root.child[childIndex] = null;
            child = null;
            root.childCount--;

        }
        return ans;
    }

    public void remove(String word) {
        if (remove(root, word)) {
            numWords--;
        }
    }

    // private int countWords(TrieNode root) {
    // if(root==null){
    // return 0;
    // }

    // int smallAns = 0;
    // int ans = 0;
    // for (int i = 0; i < 26; i++) {
    // if (root.child[i] != null) {
    // smallAns += countWords(root.child[i]);
    // if(root.child[i].isTerminating){
    // ans++;
    // }
    // }
    // }
    // return ans+smallAns;
    // }
    // public int countWords(){
    // return countWords(root);
    // }
    public int countWords() {
        return numWords;
    }
}
