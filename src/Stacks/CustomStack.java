public class CustomStack {

    private int[][] arr;
    int idx;

    public CustomStack(int maxSize) {
        arr = new int[maxSize][2];
        idx = 0;
    }
    
    public void push(int x) {
        if(idx == arr.length) return;
        arr[idx++] = new int[]{x, 0};
    }
    
    public int pop() {
        if(idx - 1 < 0) return -1;

        int[] elm = arr[--idx];

        if(idx-1 >= 0) arr[idx-1][1] += elm[1];
        
        return elm[0] + elm[1];
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k, idx);
        if(i > 0) arr[i-1][1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
