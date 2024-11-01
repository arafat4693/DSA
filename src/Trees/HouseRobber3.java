package Trees;

import java.util.HashMap;
import java.util.Objects;

public class HouseRobber3 {
//    class State{
//        TreeNode root;
//        boolean take;
//        State(TreeNode root, boolean take) {
//            this.root = root;
//            this.take = take;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof State state)) return false;
//            return take == state.take && Objects.equals(root, state.root);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(root, take);
//        }
//    }
//
//    HashMap<State, Integer> cache = new HashMap<>();
//
//    public int rob(TreeNode root) {
//        return rob(root, true);
//    }
//
//    public int rob(TreeNode root, boolean take) {
//        if(root == null) return 0;
//
//        State s = new State(root, take);
//
//        if(cache.containsKey(s)) return cache.get(s);
//
//        int total = 0;
//
//        if(take){
//            total = root.val + rob(root.left, false) + rob(root.right, false);
//        }
//
//        total = Math.max(total, rob(root.left, true)+rob(root.right, true));
//
//        cache.put(s, total);
//
//        return total;
//    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] output = new int[2]; //[With Root, Without Root];
        output[0] = root.val + left[1] + right[1];
        output[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return output;
    }
}
