import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BSTreeTest {

    private BSTree tree;

    @Before
    public void setUp() {
        tree = new BSTree();
    }

    @Test
    public void testHead() {
        tree.insert("C", 5);
        assertEquals(Integer.valueOf(5), tree.getValue("C"));
    }

    @Test
    public void testLeft() {
        tree.insert("C", 5);
        tree.insert("A", 2);
        assertEquals(Integer.valueOf(5), tree.getValue("C"));
        assertEquals(Integer.valueOf(2), tree.getValue("A"));
    }

    @Test
    public void testRight() {
        tree.insert("A", 5);
        tree.insert("C", 2);
        assertEquals(Integer.valueOf(5), tree.getValue("A"));
        assertEquals(Integer.valueOf(2), tree.getValue("C"));
    }

    @Test
    public void testLeftLeft() {
        tree.insert("C", 5);
        tree.insert("B", 2);
        tree.insert("A", 4);
        assertEquals(Integer.valueOf(5), tree.getValue("C"));
        assertEquals(Integer.valueOf(2), tree.getValue("B"));
        assertEquals(Integer.valueOf(4), tree.getValue("A"));
    }

    @Test
    public void testRightRight() {
        tree.insert("A", 5);
        tree.insert("B", 2);
        tree.insert("C", 4);
        assertEquals(Integer.valueOf(5), tree.getValue("A"));
        assertEquals(Integer.valueOf(2), tree.getValue("B"));
        assertEquals(Integer.valueOf(4), tree.getValue("C"));
    }

    @Test
    public void testLeftRight() {
        tree.insert("C", 5);
        tree.insert("A", 2);
        tree.insert("B", 4);
        assertEquals(Integer.valueOf(5), tree.getValue("C"));
        assertEquals(Integer.valueOf(2), tree.getValue("A"));
        assertEquals(Integer.valueOf(4), tree.getValue("B"));
    }

    @Test
    public void testRightLeft() {
        tree.insert("A", 5);
        tree.insert("C", 2);
        tree.insert("B", 4);
        assertEquals(Integer.valueOf(5), tree.getValue("A"));
        assertEquals(Integer.valueOf(2), tree.getValue("C"));
        assertEquals(Integer.valueOf(4), tree.getValue("B"));
    }

    @Test
    public void testEverything() {
        tree.insert("B", 5);
        tree.insert("A", 2);
        tree.insert("D", 4);
        tree.insert("C", 1);
        List<Pair<String, Integer>> entries = tree.getEntries();
        assertEquals(4, entries.size());
        assertEquals(Pair.of("A", 2), entries.get(0));
        assertEquals(Pair.of("B", 5), entries.get(1));
        assertEquals(Pair.of("C", 1), entries.get(2));
        assertEquals(Pair.of("D", 4), entries.get(3));
    }

}
