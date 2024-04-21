package Math;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MaxPointsOnALine {
//    public int maxPoints(int[][] points) {
//        int res = 1;
//
//        for(int i = 0; i < points.length; i++){
//            int x1 = points[i][0], y1 = points[i][1];
//            for(int j = i+1; j < points.length; j++){
//                int x2 = points[j][0], y2 = points[j][1];
//                int count = 2;
//                for(int k = j+1; k < points.length; k++){
//                    int x3 = points[k][0], y3 = points[k][1];
//
//                    int a = (y3-y1) * (x2-x1);
//                    int b = (y2-y1) * (x3-x1);
//
//                    if(a == b) count++;
//                }
//                res = Math.max(res, count);
//            }
//        }
//
//        return res;
//    }

//    public int maxPoints(int[][] points){
//        int res = 1;
//
//        for(int i = 0; i < points.length; i++){
//            HashMap<Double, Integer> lines = new HashMap<>();
//            int x1 = points[i][0], y1 = points[i][1];
//
//            for(int j = 0; j < points.length; j++){
//                if(i == j) continue;
//
//                int x2 = points[j][0], y2 = points[j][1];
//                double angle = Math.atan2((y2 - y1), (x2-x1));
//
//                lines.put(angle, lines.getOrDefault(angle, 1)+1);
//            }
//
//            for(double k : lines.keySet()) res = Math.max(res, lines.get(k));
//        }
//
//        return res;
//    }

    public int maxPoints(int[][] points){
        int res = 1;

        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> lines = new HashMap<>();
            int x1 = points[i][0], y1 = points[i][1];

            for(int j = i+1; j < points.length; j++){
                int x2 = points[j][0], y2 = points[j][1];

                double slope;

                if(x1 == x2) slope = Integer.MAX_VALUE;
                else if(y1 == y2) slope = Integer.MIN_VALUE;
                else slope = (double) (y2 - y1) /(x2-x1);

                lines.put(slope, lines.getOrDefault(slope, 1)+1);
            }

            for(double k : lines.keySet()) res = Math.max(res, lines.get(k));
        }

        return res;
    }
}
