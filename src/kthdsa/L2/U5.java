package kthdsa.L2;

import java.util.Arrays;

public class U5 {
    public String robotDFS(String word){
        String[] res = new String[1];
        dfs("", word, res, 0);
        return "The word '" + word + "' takes at least " + res[0].length()+ " steps. SOLUTION: " + res[0];
    }

    private void dfs(String path, String word, String[] res, int depth){
        if(word.equals("ABCDE")){
            if(res[0] == null || res[0].length() > path.length()) res[0] = path;
            return;
        }
        if(depth > 15) return;

        dfs(path+"b", opB(word), res, depth + 1);
        dfs(path+"s", opS(word), res, depth + 1);
    }

    public String opB(String word){
        char[] wordChars = word.toCharArray();
        char temp = wordChars[0];
        wordChars[0] = wordChars[1];
        wordChars[1] = temp;
        return new String(wordChars);
    }

    public String opS(String word){
        return word.charAt(word.length() - 1) + word.substring(0, word.length() - 1);
    }
    //ssssbssbsbs
    //sbsbssbssb
}
