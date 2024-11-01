package Strings;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        int currChars = 0;

        for(String word : words){
            currChars += word.length();

            if(currChars+curr.size() > maxWidth) {
                currChars -= word.length();

                StringBuilder s = new StringBuilder();

                s.append(curr.get(0));

                if(curr.size() == 1){
                    s.append(" ".repeat(maxWidth-s.length()));
                }else{
                    int left = maxWidth - currChars;

                    for(int i = 1; i < curr.size(); i++){
                        int count = (int)Math.ceil((double)left/(curr.size()-i));
                        s.append(" ".repeat(count)).append(curr.get(i));

                        left -= count;
                    }
                }

                res.add(s.toString());

                currChars = word.length();
                curr.clear();
            }

            curr.add(word);
        }

        StringBuilder s = new StringBuilder();
        s.append(curr.get(0));
        for(int i = 1; i < curr.size(); i++){
            s.append(" ").append(curr.get(i));
        }
        s.append(" ".repeat(maxWidth-s.length()));

        res.add(s.toString());

        return res;
    }
}
