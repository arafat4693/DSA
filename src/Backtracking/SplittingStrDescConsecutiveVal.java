package Backtracking;

public class SplittingStrDescConsecutiveVal {
    // public boolean splitString(String s) {
    //     long num = 0;
    //     for(int i = 0; i < s.length()-1; i++){
    //         num = num*10 + (s.charAt(i)-'0');
    //         if(dfs(s, i+1, num)) return true;
    //     }
    //     return false;
    // }

    // private boolean dfs(String s, int idx, long prev){
    //     if(idx >= s.length()) return true;

    //     long num = 0;
    //     for(int i = idx; i < s.length(); i++){
    //         num = num*10 + (s.charAt(i)-'0');

    //         if(prev - num == 1){
    //             if(dfs(s, i+1, num)) return true;
    //         }
    //     }

    //     return false;
    // }

    public boolean splitString(String s) {
        return dfs(s, 0, -1);
    }

    private boolean dfs(String s, int idx, long prev){
        long num = 0;

        for(int i = idx; i < s.length(); i++){
            num = num*10 + (s.charAt(i)-'0');
            if(prev == -1){
                if(dfs(s, i+1, num)) return true;
            }else if(prev - num == 1){
                if(i == s.length()-1 || dfs(s, i+1, num)) return true;
            }
        }

        return false;
    }
}
