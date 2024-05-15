package Stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
//    public String simplifyPath(String path) {
//        List<String> p = new ArrayList<>();
//
//        StringBuilder s = new StringBuilder();
//        for(int i = 0; i < path.length(); i++){
//            if(path.charAt(i) == '/'){
//                if(!s.isEmpty()){
//                    if(s.toString().equals("/..")){
//                        if(!p.isEmpty()) p.remove(p.size()-1);
//                    }
//                    else if(!s.toString().equals("/.") && !s.toString().equals("/")) p.add(s.toString());
//                }
//                s.setLength(0);
//                s.append('/');
//                continue;
//            }
//            s.append(path.charAt(i));
//        }
//
//        if(!s.isEmpty()){
//            if(s.toString().equals("/..")){
//                if(!p.isEmpty()) p.remove(p.size()-1);
//            } else if(s.toString().equals("/.")) p.add("/");
//            else p.add(s.toString());
//        }
//
//        StringBuilder res = new StringBuilder();
//        for(String i : p){
//            res.append(i);
//        }
//
//        if(res.length() > 1 && res.charAt(res.length()-1) == '/') res.deleteCharAt(res.length()-1);
//
//        return res.toString();
//    }

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(String s : path.split("/")){
            if(s.isEmpty() || s.equals(".")) continue;
            if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else st.add(s);
        }

        if(st.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0, st.pop()).insert(0, "/");
        }

        return res.toString();
    }
}
