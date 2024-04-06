package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int idx, List<String> res, List<String> subRes){
        if(subRes.size() == 4){
            if(idx != s.length()) return;
            StringBuilder ip = new StringBuilder();
            for(String a : subRes) ip.append(a).append('.');
            ip.deleteCharAt(ip.length()-1);
            res.add(ip.toString());
        }

        for(int i = idx; i < s.length() && i < idx+3; i++){
            String digits = s.substring(idx,i+1);
            if(Integer.parseInt(digits) > 255) continue;
            if(digits.length() > 1 && digits.charAt(0) == '0') continue;
            subRes.add(digits);
            dfs(s, i+1, res, subRes);
            subRes.remove(subRes.size()-1);
        }
    }
}
