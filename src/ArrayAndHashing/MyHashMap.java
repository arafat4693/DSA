package ArrayAndHashing;

public class MyHashMap {
    static class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] arr;

    public MyHashMap() {
        arr = new Node[10000];
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        int index = key%10000;

        if(arr[index] == null) arr[index] = node;
        else{
            Node curr = arr[index], prev = arr[index];

            while(curr != null){
                if(curr.key == key) {
                    curr.value = value;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = node;
        }
    }

    public int get(int key) {
        int index = key%10000;
        Node curr = arr[index];

        if(curr == null) return -1;

        while(curr != null){
            if(curr.key == key) return curr.value;
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key%10000;
        Node curr = arr[index];

        if(curr == null) return;

        if(curr.key == key) arr[index] = curr.next;
        else{
            while(curr != null){
                if(curr.next != null && curr.next.key == key){
                    Node removing = curr.next;
                    curr.next = removing.next;
                    removing.next = null;
                    return;
                }
                curr = curr.next;
            }
        }
    }
}
