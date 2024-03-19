package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeString {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#') j++;

            int strLen = Integer.parseInt(str.substring(i, j));

//           System.out.println(strLen);

           String subStr = str.substring(j+1, j + 1 + strLen);
           res.add(subStr);

           i = strLen + j + 1;
        }

        return res;
    }
}
