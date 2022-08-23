class Trie {
    
    /**
     *  Trie is better than hashing data structures in both time & space complexities.
     *
     *  For hashing DS, inorder to insert an element or search for a element the complexity is 
     *           O(length of word) -> as we need to iterate over the entire word to compute the hash
     *
     *
     *  Trie its better because:
     *      Time-compexity :
     *
     *        Unlike hashing based DS, to find prefix which is not there we need not go through entire lenght of the word.      
     *
     *        To find all the words starting with a prefix we need to go and 
     *.       search every word to check if its starting with a given prefix lets say `ba`
     *
     *        However in tries we need not traverse all the words
     *     
     *      Space complexity: 
     *         In hash based DS: Seperate space for each word is to be allocated
     *         
     *          In trie, using prefixes we can save lot of space.
     *
     *      Insert in trie : Time complexity : O(length of the word)
     *      Overall space complexity of trie: 
     *          O( ALPHABETS_SIZE * average lenght of all words in trie * no.of words in trie)
     * 
     *      Search: O(length of the word)   
     *
     */
    
    
    class TrieNode {
        TrieNode [] children;
        boolean isEnd;
        
        public TrieNode() {
            this.children = new TrieNode [26];
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    
    /*
     * Time complexity : O(length of the word)
     * Space complexity : O( 26 * length of word)
     * Overall space complexity : 
     * O( ALPHABETS_SIZE * average lenght of all words in trie * no.of words in trie)
     *
     ******/
    
    public void insert(String word) {
        
        TrieNode curr = root;
        // Iterate over each charcter 
        for(int i = 0; i < word.length(); i++) {
            
            //Current character
            char c = word.charAt(i);
            
            //Array index of character c
            int idx = c - 'a';
            
            //Check if its already in on of the current node's children
            if(curr.children[idx] == null) {
                //Insert in to children at idx
                curr.children[idx] = new TrieNode();  
            }
            
            curr = curr.children[idx];
        }
        
        curr.isEnd = true;
        
    }
    
    /**
     * Time complexity : O(length of the word)
     *   
     */
    
    public boolean search(String word) {
        
        TrieNode curr = root;
        //Iterate over each character inside the word and check if 
        //current node's children has this character
        for(int i = 0; i< word.length(); i++) {
          char c = word.charAt(i);
            
          if(curr.children[c - 'a'] == null) {
              return false;
          }
            
            curr = curr.children[c - 'a'];
        }
        
        return curr.isEnd;
    }
    
    /**
     * Time complexity : O(length of the prefix)   
     */
    public boolean startsWith(String prefix) {
        
        TrieNode curr = root;
        
        for(int i = 0; i< prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            
            curr = curr.children[c - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
