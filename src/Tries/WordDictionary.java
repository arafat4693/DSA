package Tries;

public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] wordChars = word.toCharArray();
        TrieNode curr = this.root;
        for(char c : wordChars){
            if(!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        char[] wordChars = word.toCharArray();
        return dfs(wordChars, this.root, 0);
    }

    private boolean dfs(char[] wordChars, TrieNode currentRoot, int idx){
        TrieNode cur = currentRoot;
        for(int i = idx; i < wordChars.length; i++){

            if(wordChars[idx] == '.'){
                for(TrieNode t : cur.children.values()){
                    if(dfs(wordChars, t, idx + 1)) return true;
                }
                return false;
            }else{
                TrieNode isChar = cur.children.get(wordChars[idx]);
                if(isChar == null) return false;
                cur = isChar;
            }
        }
        return cur.isEndOfWord;
    }
}
