package Tries.Palindrome;


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

	private TrieNode root;
	public int count;

	public Trie() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}





	/*..................... Palindrome Pair................... */


	public boolean isPalindromePair(ArrayList<String> words) {
        for(String s: words){
            add(s);
        }
        for(int i=0;i<words.size();i++){
            for(int j=0;j<words.get(i).length();j++){
            	StringBuilder sb=new StringBuilder(words.get(i).substring(0,words.get(i).length()-j));
            	sb.reverse();
           		if(search(sb.toString())){
                	return true;
                }
         	}
        
        }
            Trie t=new Trie();
        for(int i=0;i<words.size();i++){
            int lenght=words.get(i).length();
            if(lenght%2==0)
                t.add(words.get(i).substring(lenght/2,lenght));
            else{
                t.add(words.get(i).substring((lenght/2)+1,lenght));
            }
        }
        for(int i=0;i<words.size();i++){
            StringBuilder sb=new StringBuilder(words.get(i));
            if(sb.length()%2==0){
                sb.reverse();
                if(t.search(sb.toString())){
                    return true;
                }
            }
            else{
                sb=new StringBuilder(sb.substring(0, sb.length()-1));
                sb.reverse();
                if(t.search(sb.toString())){
                    return true;
                }
            }

        }
        return false;
        
	}


	
} 