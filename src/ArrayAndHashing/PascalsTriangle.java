package ArrayAndHashing;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int r = 1;
        while(r <= numRows){
            List<Integer> subRes = new ArrayList<>();
            subRes.add(1);
            if(r == 1){
                res.add(subRes);
                r++;
                continue;
            }
            List<Integer> prev = res.get(r-2);
            for(int i = 1; i < r-1; i++){
                subRes.add(prev.get(i-1)+prev.get(i));
            }
            subRes.add(1);
            res.add(subRes);
            r++;
        }

        return res;
    }
}
