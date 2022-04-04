// Problem - https://leetcode.com/problems/design-add-and-search-words-data-structure/
// Explanation - 
//    	- For Trie data stucture basics, check the solution to 208-MEDIUM-Implement Trie.
//      - For DFS basics, check Shank's notes!

class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;
    private static int capacity = 26;
    
    public TrieNode() {
        children = new TrieNode[capacity];
        isEnd = false;
    }
    
    public TrieNode[] getChildren() {
        return children;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void setIsEnd() {
        isEnd = true;
    }
    
    public void underIsEnd() {
        isEnd = false;
    }
    
    public boolean containsKey(char ch) {
        return children[ch-'a']!=null;
    }
    
    public TrieNode get(char ch) {
        return children[ch-'a'];
    }
    
    public void set(char ch, TrieNode node) {
        children[ch-'a'] = node;
    }
}

class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {        
        TrieNode node = root;
        
        for (int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            
            if (!node.containsKey(ch)) {
                TrieNode child = new TrieNode();
                node.set(ch, child);
            }
            
            node = node.get(ch);
        }
        
        node.setIsEnd();
    }
    
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean search(String word, TrieNode curNode) {
        TrieNode node = curNode;
        
        for (int i=0;i<word.length(); ++i) {
            char ch = word.charAt(i);
            
            if (ch=='.') {
                for (TrieNode child: node.getChildren()) {
                    if (child!=null && search(word.substring(i+1), child)) return true;
                }
                
                return false;
            } else {
                if (!node.containsKey(ch)) {
                    return false;
                } 
                
                node = node.get(ch);
            }
        }
        
        return node!=null && node.isEnd();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */