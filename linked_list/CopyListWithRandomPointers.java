//https://leetcode.com/problems/copy-list-with-random-pointer/description/

public class CopyListWithRandomPointers {
    /**
     * First we will create a copy with the value only in a hashmap.
     * We have to do this because initially we will not have next and random nodes to point to.
     * After that in another iteration we will add the next and random pointers.
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> copy = new HashMap<>();
        copy.put(null, null);

        Node curr = head;

        while (curr != null) {
            Node node = new Node(curr.val);
            copy.put(curr, node);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node copyN = copy.get(curr);
            copyN.next = copy.get(curr.next);
            copyN.random = copy.get(curr.random);
            curr = curr.next;
        }

        return copy.get(head);
    }
}
