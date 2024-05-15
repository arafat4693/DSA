package ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SrcSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> res = new ArrayList<>();

//        for(int i = 0; i < searchWord.length(); i++){
//            List<String> subRes = new ArrayList<>();
//            for(String product : products) {
//                if(product.startsWith(searchWord.substring(0, i+1))) subRes.add(product);
//                if(subRes.size() == 3) break;
//            }
//            res.add(subRes);
//        }

        for(int i = 0; i < searchWord.length(); i++) res.add(new ArrayList<>());

        for(String p : products){
            for(int i = 0; i < p.length() && i < searchWord.length() && p.charAt(i) == searchWord.charAt(i); i++){
                if(res.get(i).size() < 3){
                    res.get(i).add(p);
                }
            }
        }

        return res;
    }
}
