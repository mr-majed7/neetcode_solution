//https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class ImplementTrie {
    public class Node {
        HashMap<Character, Node> child = new HashMap<>();
        boolean end = false;
    }

    class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
            }
            cur.end = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.child.containsKey(c)) {
                    return false;
                }
                cur = cur.child.get(c);
            }
            return cur.end;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                if (!cur.child.containsKey(c)) {
                    return false;
                }
                cur = cur.child.get(c);
            }
            return true;
        }
    }
}
