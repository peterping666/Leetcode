import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
