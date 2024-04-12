package Strings;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> seen = new HashSet<>();

//        for(String email : emails){
//            StringBuilder e = new StringBuilder();
//            int flag = 0;
//            for(int i = 0; i < email.length(); i++){
//                if(email.charAt(i) == '@') flag = 2;
//                if(email.charAt(i) == '+' && flag == 0) flag = 1;
//                if(flag == 1 || (email.charAt(i) == '.' && flag == 0)) continue;
//                e.append(email.charAt(i));
//            }
//            seen.add(e.toString());
//        }

        for(String email : emails){
            int plus = email.indexOf('+');
            int at = email.indexOf('@');
            String str = "";

            if(plus >= 0) str = email.substring(0, plus);
            else str = email.substring(0, at);

            seen.add(str.replace(".", "") + email.substring(at));
        }

        return seen.size();
    }
}
