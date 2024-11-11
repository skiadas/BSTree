public class Node {
    public String key;
    public Integer value;
    public Node left;
    public Node right;

    Node(String key, Integer value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
