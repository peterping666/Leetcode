import java.util.ArrayDeque;
import java.util.Deque;

public class _388_LongestAbsoluteFilePath {
    /**
     * Time O(n)
     * Space O(n)
     * @param input
     * @return
     */
    public int lengthLongestPath1(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s : input.split("\n")){
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while(lev + 1 < stack.size()) stack.pop(); // find parent
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param input
     * @return
     */
    public int lengthLongestPath2(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
            if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
        }
        return maxLen;
    }
}
