import java.util.ArrayList;
import java.util.List;

public class BSTree {
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
        List<Node> pending = new ArrayList<>();
        List<Pair<String, Integer>> result = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            pending.add(curr);
            curr = curr.left;
        }
        while (!pending.isEmpty()) {
            curr = pending.remove(pending.size() - 1);
            result.add(Pair.of(curr.key, curr.value));
            curr = curr.right;
            while (curr != null) {
                pending.add(curr);
                curr = curr.left;
            }
        }

        return result;
    }
}
