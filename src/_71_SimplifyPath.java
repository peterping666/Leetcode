import java.util.Stack;

public class _71_SimplifyPath {
    /**
     * Time O(n)
     * Space O(n)
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");
        for (String directory : components) {
            if(directory.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(!directory.equals(".") && !directory.equals("")) {
                stack.push(directory);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        return result.length() > 0 ? result.toString() : "/" ;
    }
}
