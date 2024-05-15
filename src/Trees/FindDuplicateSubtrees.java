package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicateSubtrees {
    HashMap<String, TreeNode> res = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(res.values());
    }

    private String dfs(TreeNode node){
        if(node == null) return "-";
        String ans = "<"+dfs(node.left) + node.val + dfs(node.right)+">"; //inorder
        if(!visited.add(ans)) res.put(ans, node);
        return ans;
    }
}
