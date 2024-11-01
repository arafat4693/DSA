package Strings;

public class Largest3SameDigitInString {
    public String largestGoodInteger(String num) {
//        int l = 0, n = 0;
//        StringBuilder res = new StringBuilder();
//        StringBuilder ans = new StringBuilder();
//
//        for(int i = 0; i < num.length(); i++){
//            if(!res.isEmpty() && res.charAt(res.length()-1) != num.charAt(i)) {
//                l = i;
//                res.setLength(0);
//                res.append(num.charAt(i));
//                continue;
//            }
//            res.append(num.charAt(i));
//            if(i-l+1 < 3) continue;
//            int d = Integer.parseInt(res.toString());
//            if(d >= n){
//                n = d;
//                ans.setLength(0);
//                ans.append(res);
//            }
//            l = i+1;
//            res.setLength(0);
//        }
//
//        return ans.toString();

        String[] arr = {"000", "111", "222", "333", "444", "555", "666", "777","888", "999"};
        for(int i = arr.length-1;i >=0;--i){
            if(num.contains(arr[i])){
                return arr[i];
            }
        }
        return "";
    }
}
