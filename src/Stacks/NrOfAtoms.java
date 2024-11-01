package Stacks;

import java.util.*;

public class NrOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Character> st = new Stack<>();
        HashMap<String, String> map = new HashMap<>();

        int i = 0;

        while(i < formula.length()) {
            if(formula.charAt(i) != ')') st.add(formula.charAt(i++));
            else {
                int p = 1, mult = 0;
                i++;
                while(i < formula.length() && Character.isDigit(formula.charAt(i))){
                    mult = mult*p + (formula.charAt(i)-'0');
                    p *= 10;
                    i++;
                }
                p = 1;
                if(mult == 0) mult = 1;

                StringBuilder res = new StringBuilder();
                int freq = 0;
                StringBuilder str = new StringBuilder();

                while(st.peek() != '(') {
                    char top = st.pop();
                    if(top >= 'A' && top <= 'Z') {
                        str.insert(0, top);
                        if(freq == 0) freq = 1;

                        int total = freq * mult;
                        if(total > 1) res.insert(0, total);
                        res.insert(0, str);

                        str.setLength(0);
                        freq = 0;
                        p = 1;
                    }else if(Character.isDigit(top)) {
                        freq = ((top - '0')*p) + freq;
                        p *= 10;
                    }
                    else str.insert(0, top);
                }

                st.pop();

                char[] arr = res.toString().toCharArray();
                for(char c : arr) st.add(c);
            }
        }

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();

        while(!st.isEmpty()) {
            char top = st.pop();
            if(Character.isDigit(top)) value.append(top);
            else if(top >= 'A' && top <= 'Z') {
                key.append(top);

                String k = key.reverse().toString();
                String v = value.reverse().toString();

                if(map.containsKey(k)) {
                    int oldValue = Integer.parseInt(map.get(k));
                    int extra = v.isEmpty() ? 1 : Integer.parseInt(v);
                    map.put(k, String.valueOf(oldValue+extra));
                } else map.put(k, v);

                key.setLength(0);
                value.setLength(0);
            }else key.append(top);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder res = new StringBuilder();
        for(String k : keys) res.append(k).append(map.get(k));

        return res.toString();
    }
}
