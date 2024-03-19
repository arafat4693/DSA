package Tries;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode currentRoot = this.root;
        for (char aChar : chars) {
            if (!currentRoot.children.containsKey(aChar)) currentRoot.children.put(aChar, new TrieNode());
            currentRoot = currentRoot.children.get(aChar);
        }
        currentRoot.isEndOfWord = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode currentRoot = this.root;
        for (char aChar : chars) {
            TrieNode isChar = currentRoot.children.get(aChar);
            if (isChar == null) return false;
            currentRoot = isChar;
        }
        return currentRoot.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode currentRoot = this.root;
        for (char aChar : chars) {
            TrieNode isChar = currentRoot.children.get(aChar);
            if (isChar == null) return false;
            currentRoot = isChar;
        }
        return true;
    }
}
