package Graphs;

import java.util.*;

public class SnakeAndLadders {
    public int snakesAndLadders(int[][] board) {
        // System.out.println(Arrays.toString(getCords(9, board.length)));

//        int[] visited = new int[board.length*board.length+1];
//        Arrays.fill(visited, -1);
//        int ans = dfs(board, 1, false, visited);
//        return ans == Integer.MAX_VALUE/2 ? -1 : ans;

        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(new int[]{1, 0});

        while(!q.isEmpty()){
            int[] top = q.poll();

            for(int i = 1; i <= 6; i++){
                int next = top[0] + i;
                int[] cords = getCords(next, board.length);
                int r = cords[0], c = cords[1];
                if(board[r][c] != -1) next = board[r][c];

                if(next == board.length*board.length) return top[1]+1;

                if(!visited.contains(next)){
                    visited.add(next);
                    q.add(new int[]{next, top[1]+1});
                }
            }
        }

        return -1;
    }

    private int dfs(int[][] board, int pos, boolean power, int[] visited){
        if(pos == board.length*board.length) return 0;

        if(visited[pos] != -1) return visited[pos];

        int ans = Integer.MAX_VALUE/2;

        for(int i = 1; i <= 6; i++){
            if(pos+i > board.length*board.length) break;
            // if(visited.contains(pos+i)) continue;

            int[] cords = getCords(pos, board.length);

            int r = cords[0], c = cords[1];

            if(board[r][c] != -1 && !power){
                ans = Math.min(ans, dfs(board, board[r][c], true, visited));
            }else{
                ans = Math.min(ans, 1 + dfs(board, pos+i, false, visited));
            }
        }
        System.out.println(ans + " -> " + pos);
        return visited[pos] = ans;
    }

    private int[] getCords(int target, int n){
        int row = (target-1)/n;

        int col = (target-1)%n;
        if(row % 2 == 1) col = n - 1 - col;

        return new int[]{n-row-1, col};
    }
}
