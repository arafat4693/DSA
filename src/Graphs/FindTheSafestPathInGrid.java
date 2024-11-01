package Graphs;

import java.util.*;

public class FindTheSafestPathInGrid {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int r = grid.size(), c = grid.get(0).size();

        int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        int[][] safe = new int[r][c];
        for(int[] row : safe) Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid.get(i).get(j) == 0) continue;
                queue.add(new int[]{i, j});
                safe[i][j] = 0;
            }
        }

        while(!queue.isEmpty()){
            int[] top = queue.poll();

            for(int[] dir : dirs){
                int row = top[0] + dir[0], col = top[1] + dir[1];

                if(row < 0 || row == r || col < 0 || col == c || safe[row][col] != -1) continue;
                safe[row][col] = safe[top[0]][top[1]] + 1;
                queue.add(new int[]{row, col});
            }
        }

        // System.out.println(Arrays.deepToString(safe));

//        int left = 0, right = r+c, res = 0;
//
//        while(left <= right){
//            int mid = (left + right) / 2;
//            // System.out.println(mid);
//
//            Queue<int[]> q = new LinkedList<>();
//            q.add(new int[]{0, 0});
//            int[][] vis = new int[r][c];
//
//            boolean reached = false;
//
//            while(!q.isEmpty()){
//                int[] top = q.poll();
//
//                if(safe[top[0]][top[1]] < mid) continue;
//
//                if(top[0] == r-1 && top[1] == c-1) {
//                    reached = true;
//                    break;
//                };
//
//                if(vis[top[0]][top[1]] == 1) continue;
//                vis[top[0]][top[1]] = 1;
//
//                for(int[] dir : dirs){
//                    int row = top[0] + dir[0], col = top[1] + dir[1];
//                    if(row < 0 || row == r || col < 0 || col == c || vis[row][col] == 1) continue;
//                    q.add(new int[]{row, col});
//                }
//            }
//
//            if(reached) {
//                res = mid;
//                left = mid + 1;
//            }else right = mid - 1;
//        }
//
//        return res;


        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        q.add(new int[]{0, 0, safe[0][0]});
        int[][] vis = new int[r][c];

        while(!q.isEmpty()){
            int[] top = q.poll();

            if(top[0] == r-1 && top[1] == c-1) return top[2];

            if(vis[top[0]][top[1]] == 1) continue;
            vis[top[0]][top[1]] = 1;

            for(int[] dir : dirs){
                int row = top[0] + dir[0], col = top[1] + dir[1];
                if(row < 0 || row == r || col < 0 || col == c || vis[row][col] == 1) continue;
                q.add(new int[]{row, col, Math.min(safe[row][col], top[2])});
            }
        }

        return 0;
    }
}
