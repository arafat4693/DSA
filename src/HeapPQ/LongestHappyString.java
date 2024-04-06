package HeapPQ;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LongestHappyString {
    static class Tuple{
        char c;
        int left;

        Tuple(char c, int left){
            this.c = c;
            this.left = left;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Tuple> maxHeap = new PriorityQueue<>((x, y) -> y.left - x.left);
        StringBuilder res = new StringBuilder();

        if(a != 0) maxHeap.add(new Tuple('a', a));
        if(b != 0) maxHeap.add(new Tuple('b', b));
        if(c != 0) maxHeap.add(new Tuple('c', c));

        while(!maxHeap.isEmpty()){
            Tuple c1 = maxHeap.poll();

            if(res.length() >= 2 && res.charAt(res.length()-1) == res.charAt(res.length()-2) && res.charAt(res.length()-2) == c1.c){
                if(maxHeap.isEmpty()) break;
                Tuple c2 = maxHeap.poll();
                res.append(c2.c);
                c2.left--;
                if(c2.left != 0) maxHeap.add(c2);
                maxHeap.add(c1);
            }else{
                res.append(c1.c);
                c1.left--;
                if(c1.left != 0) maxHeap.add(c1);
            }
        }

        return res.toString();
    }
}
