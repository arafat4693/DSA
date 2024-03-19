package LinkedLists;

import java.util.HashMap;

public class CpyListRndPtr {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node copyHead = new Node(head.val);

        map.put(head, copyHead);

        Node current = head;
        Node cpyCurrent = copyHead;

        while(current.next != null){
            Node nextNode = new Node(current.next.val);
            cpyCurrent.next = nextNode;
            cpyCurrent = nextNode;
            map.put(current.next, nextNode);
            current = current.next;
        }

        current = head;
        while(current != null){
            Node correspondingNode = map.get(current);
            correspondingNode.random = map.get(current.random);
            current = current.next;
        }

        return copyHead;
    }
}
