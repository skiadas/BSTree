import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTree implements Iterable<Pair<String, Integer>> {
    Node head = null;

    void insert(String key, Integer value) {
        if (head == null) {
            head = new Node(key, value);
            return;
        }
        Node curr = head;
        while (true) {
            int comp = curr.key.compareTo(key);
            if (comp == 0) {
                curr.value = value;
                return;
            }
            if (comp < 0) {
                if (curr.right == null) {
                    curr.right = new Node(key, value);
                    return;
                } else {
                    curr = curr.right;
                }
            } else {
                if (curr.left == null) {
                    curr.left = new Node(key, value);
                    return;
                } else {
                    curr = curr.left;
                }
            }
        }
    }

    Integer getValue(String key) {
        Node curr = head;
        while (curr != null) {
            int comp = curr.key.compareTo(key);
            if (comp == 0) return curr.value;
            if (comp < 0) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return null;
    }

    List<Pair<String, Integer>> getEntries() {
        List<Pair<String, Integer>> result = new ArrayList<>();
        for (Pair<String, Integer> pair : this) {
            result.add(pair);
        }
        return result;
    }

    public Iterator<Pair<String, Integer>> iterator() {
        return new TreeIterator(head);
    }

    static class TreeIterator implements Iterator<Pair<String, Integer>> {
        private final List<Node> pending = new ArrayList<>();

        TreeIterator(Node head) {
            addAllLeftToPending(head);
        }

        private void addAllLeftToPending(Node curr) {
            while (curr != null) {
                pending.add(curr);
                curr = curr.left;
            }
        }

        public boolean hasNext() {
            return !pending.isEmpty();
        }

        public Pair<String, Integer> next() {
            Node node = pending.remove(pending.size() - 1);
            addAllLeftToPending(node.right);
            return Pair.of(node.key, node.value);
        }
    }
}
