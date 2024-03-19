package kthdsa.L2;

import java.util.LinkedList;
import java.util.Queue;

class Word{
    String path;
    String word;

    public Word(String path, String word){
        this.word = word;
        this.path = path;
    }
}

public class U6 {
    public String robotBFS(String word){
        Queue<Word> dq = new LinkedList<>();
        dq.offer(new Word("", word));

        while(true){
            int qLen = dq.size();
            for(int i = 0; i < qLen; i++){
                if(dq.peek().word.equals("ABCDE")) return "The word '" + word + "' takes at least " + dq.peek().path.length() + " steps. SOLUTION: " + dq.poll().path;

                dq.offer(new Word(dq.peek().path + "b", opB(dq.peek().word)));
                dq.offer(new Word(dq.peek().path + "s", opS(dq.peek().word)));

                dq.poll();
            }
        }
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
}
