package kthdsa.L3;

public class BBSTMain {
    public static void buildTree(BBST<Integer> bst, int[] arrayToTree){
        for(int data : arrayToTree)
            bst.add(data);
    }
    public static void main(String[] args) {
        BBST<Integer> bst= new BBST<>();
        int[] arrayToTree = new int[] {30, 20, 40, 15, 25, 35, 45 ,10, 17, 22, 27, 32, 37, 42, 47, 16, 23, 28, 39, 49, 29, 51};
        buildTree(bst,arrayToTree);

        for(int i=0;i<52;i++)
            System.out.print(""+i+":"+bst.getNextLarger(i)+" ");
    }
}
