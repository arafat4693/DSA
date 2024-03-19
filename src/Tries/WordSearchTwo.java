package Tries;

import java.util.ArrayList;
import java.util.List;

public class WordSearchTwo {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        this.insert(root, words);
        List<String> res = new ArrayList<>();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                dfs(board, row, col, root, res, new StringBuilder());
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, TrieNode root, List<String> res, StringBuilder subRes){
        if(root.isEndOfWord && !res.contains(subRes.toString())){
            res.add(subRes.toString());
        }

        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || root.children.get(board[row][col]) == null) return;

        char temp = board[row][col];
        subRes.append(temp);
        board[row][col] = '#';

        dfs(board, row, col+1, root.children.get(temp), res, subRes);
        dfs(board, row, col-1, root.children.get(temp), res, subRes);
        dfs(board, row+1, col, root.children.get(temp), res, subRes);
        dfs(board, row-1, col, root.children.get(temp), res, subRes);

        if(root.children.get(temp).children.isEmpty()) root.children.remove(temp);

        board[row][col] = temp;
        subRes.deleteCharAt(subRes.length() - 1);
    }

    private void insert(TrieNode root, String[] words){
        TrieNode curr = root;

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (!curr.children.containsKey(word.charAt(j))) curr.children.put(word.charAt(j), new TrieNode());
                curr = curr.children.get(word.charAt(j));
            }
            curr.isEndOfWord = true;
            curr = root;
        }
    }
}
