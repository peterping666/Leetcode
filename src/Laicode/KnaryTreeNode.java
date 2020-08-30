package Laicode;

import java.util.ArrayList;
import java.util.List;

public class KnaryTreeNode {
    int key;
    List<KnaryTreeNode> children;
    public KnaryTreeNode(int key) {
        this.key = key;
        this.children = new ArrayList<>();
    }
}
