package kthdsa.F2;

public class LListMain {
    public static void main(String[] args) {
        Node node1 = new Node("Gilgamesh");
        Node node2 = new Node("löper");
        Node node3 = new Node("på");
        Node node4 = new Node("stäppen");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node current = node1;

        // Skriv ut innehållet i listan medan du går igenom den
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        // Ta bort noden med data "på"
        current = node1;
        while(current != null){
            if(current.next.data.equals("på")){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        // Skriv ut listan igen efter att ha tagit bort "på"
        current = node1;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
