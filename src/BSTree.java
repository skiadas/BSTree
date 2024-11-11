import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTree implements Iterable<Pair<String, Integer>> {
    Node head = null;

    void insert(String key, Integer value) {
        if (head == null) {
            head = new Node(key, value);
        } else {
            insert(head, key, value);
        }
    }

    void insert(Node node, String key, Integer value) {
        int comp = node.key.compareTo(key);
        if (comp == 0) {
            node.value = value;
        }
        if (comp < 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
            } else {
                insert(node.right, key, value);
            }
        } else {
            if (node.left == null) {
                node.left = new Node(key, value);
            } else {
                insert(node.left, key, value);
            }
        }
    }

    Integer getValue(String key) {
        if (head != null) return getValue(head, key);
        return null;
    }

    Integer getValue(Node node, String key) {
        int comp = node.key.compareTo(key);
        if (comp == 0) return node.value;
        if (comp < 0) {
            if (node.right == null) return null;
            return getValue(node.right, key);

        } else {
            if (node.left == null) return null;
            return getValue(node.left, key);
        }
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
