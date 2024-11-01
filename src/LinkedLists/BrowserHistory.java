package LinkedLists;

public class BrowserHistory {
    class Node{
        Node prev;
        Node next;
        String url;
        Node(String url){
            this.url = url;
        }
    }

    private Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }

    public String back(int steps) {
        int step = 0;
        while(step != steps && curr.prev != null){
            step++;
            curr = curr.prev;
        }

        return curr.url;
    }

    public String forward(int steps) {
        int step = 0;
        while(step != steps && curr.next != null){
            step++;
            curr = curr.next;
        }

        return curr.url;
    }
}
