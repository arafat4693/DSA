package Stacks;

import java.util.Stack;

public class DecodeString {
//    public String decodeString(String s) {
//        Stack<Character> charSt = new Stack<>();
//        Stack<Character> intSt = new Stack<>();
//
//        StringBuilder res = new StringBuilder();
//
//        for(int i = 0; i < s.length() ; i++){
//            if(Character.isDigit(s.charAt(i))){
//                if(intSt.isEmpty()){
//                    StringBuilder subRes = new StringBuilder();
//                    while(!charSt.isEmpty()) subRes.append(charSt.pop());
//                    subRes.reverse();
//
//                    res.append(subRes);
//                }
//                intSt.push(s.charAt(i));
//            }
//            else if(s.charAt(i) == '['){
//                charSt.add('[');
//                intSt.add('[');
//            }
//            else if(s.charAt(i) != ']') charSt.push(s.charAt(i));
//
//            if(s.charAt(i) == ']') {
//                intSt.pop();
//
//                StringBuilder intS = new StringBuilder();
//                while(!intSt.isEmpty() && intSt.peek() != '[') intS.append(intSt.pop());
//                intS.reverse();
//
//                int f = Integer.parseInt(intS.toString());
//
//                StringBuilder subRes = new StringBuilder();
//                while(charSt.peek() != '[') subRes.append(charSt.pop());
//
//                charSt.pop();
//                subRes.reverse();
//                String str = subRes.toString().repeat(Math.max(0, f));
//
//                if(!intSt.isEmpty() && intSt.peek() == '['){
//                    for(char c : str.toCharArray()) charSt.push(c);
//                }else res.append(str);
//            }
//        }
//
//        StringBuilder subRes = new StringBuilder();
//        while(!charSt.isEmpty()) subRes.append(charSt.pop());
//        subRes.reverse();
//
//        res.append(subRes);
//
//        return res.toString();
//    }


    int index = 0;

    public String decodeString(String s) {

        StringBuilder decoded = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {

            // character is a letter of encoded
            if (!Character.isDigit(s.charAt(index))) decoded.append(s.charAt(index++));

                // character is number or [ ]
            else {
                int k = 0;

                // case: number
                while (index < s.length() && Character.isDigit(s.charAt(index))) k = k * 10 + s.charAt(index++) - '0';

                // case: [
                index++;
                String answer = decodeString(s);

                // case: ]
                index++;

                // add k*encoded to decoded
                while (k-- > 0) decoded.append(answer);
            }
        }
        return new String(decoded);
    }
}
