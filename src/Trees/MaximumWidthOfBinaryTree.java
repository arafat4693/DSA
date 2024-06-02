package Trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    class State{
        TreeNode node;
        int num;
        State(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<State> dq = new LinkedList<>();
        dq.add(new State(root, 1));

        while(!dq.isEmpty()){
            int size = dq.size(), l = 0, r = 0;

            for(int i = 0; i < size; i++){
                State top = dq.poll();
                if(i == 0) l = top.num;
                if(i == size-1) r = top.num;

                if(top.node.left != null) dq.add(new State(top.node.left, top.num*2));
                if(top.node.right != null) dq.add(new State(top.node.right, top.num*2+1));
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}
