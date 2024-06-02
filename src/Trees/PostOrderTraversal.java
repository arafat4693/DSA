package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    class State{
        TreeNode node;
        boolean visited;
        State(TreeNode node, boolean visited){
            this.node = node;
            this.visited = visited;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<State> st = new Stack<>();
        st.push(new State(root, false));
        List<Integer> res = new ArrayList<>();

        while(!st.isEmpty()){
            TreeNode n = st.peek().node;
            boolean v = st.pop().visited;

            if(n != null){
                if(v){
                    res.add(n.val);
                }else{
                    st.push(new State(n, true));
                    st.push(new State(n.right, false));
                    st.push(new State(n.left, false));
                }
            }
        }

        return res;
    }
}
