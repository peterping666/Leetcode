import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _1472_DesignBrowserHistory {
    /**
     * Time O(n)
     * Space O(n)
     */
    class BrowserHistory1 {
        private Deque<String> history;
        private Deque<String> forward;

        public BrowserHistory1(String homepage) {
            history = new ArrayDeque<>();
            forward = new ArrayDeque<>();
            history.offerFirst(homepage);
        }

        public void visit(String url) {
            forward = new ArrayDeque<>();
            history.offerFirst(url);
        }

        public String back(int steps) {
            while(steps-- > 0 && history.size() > 1) {
                forward.offerFirst(history.pollFirst());
            }
            return history.peekFirst();
        }

        public String forward(int steps) {
            while(steps-- > 0 && forward.size() > 0) {
                history.offerFirst(forward.pollFirst());
            }
            return history.peekFirst();
        }
    }

    class BrowserHistory2 {

        public class Node{
            String url;
            Node next, prev;
            public Node(String url) {
                this.url = url;
                next = null;
                prev = null;
            }
        }

        Node head, curr;
        public BrowserHistory2(String homepage) {
            head = new Node(homepage);
            curr = head;
        }

        public void visit(String url) {
            Node node = new Node(url);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }

        public String back(int steps) {
            while (curr.prev != null && steps-- > 0) {
                curr = curr.prev;
            }
            return curr.url;
        }

        public String forward(int steps) {
            while (curr.next != null && steps-- > 0) {
                curr = curr.next;
            }
            return curr.url;
        }
    }

    class BrowserHistory3 {
        private List<String> list;
        private int index;
        public BrowserHistory3(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            index = 0;
        }

        public void visit(String url) {
            if(index < list.size()) {
                list = list.subList(0, index + 1);
            }
            list.add(url);
            index++;
        }

        public String back(int steps) {
            index = Math.max(0, index - steps);
            return list.get(index);
        }

        public String forward(int steps) {
            index = Math.min(list.size() - 1, index + steps);
            return list.get(index);
        }
    }
}
