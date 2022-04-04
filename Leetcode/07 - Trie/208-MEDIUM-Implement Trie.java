// Problem - https://leetcode.com/problems/implement-trie-prefix-tree/
// Explanation - https://leetcode.com/problems/implement-trie-prefix-tree/solution/

class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;
    private static int capacity = 26;
    
    public TrieNode() {
        children = new TrieNode[capacity];
        isEnd = false;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void setIsEnd() {
        isEnd = true;
    }
    
    public void unsetIsEnd() {
        isEnd = false;
    }
    
    public boolean containsKey(char ch) {
        return children[ch-'a'] != null;
    }
                        
    public TrieNode get(char ch) {
        return children[ch-'a'];
    }
                        
    public void set(char ch, TrieNode node) {
        children[ch-'a'] = node;
    }
}

class Trie {
    
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public TrieNode get() {
        return root;
    }
    
    public void insert(String word) {
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
    
    // Returns the node where search ends
    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            
            if (!node.containsKey(ch)) {
                return null;
            } 
            
            node = node.get(ch);
        }
        
        return node;
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();        
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */