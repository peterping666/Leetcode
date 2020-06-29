import java.util.ArrayList;
import java.util.List;

public class _241_DifferentWaystoAddParentheses {
    /**
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> op1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> op2 = diffWaysToCompute(input.substring(i + 1));
                for(int x : op1) {
                    for(int y : op2) {
                        if(c == '-') {
                            list.add(x - y);
                        } else if(c == '+') {
                            list.add(x + y);
                        } else {
                            list.add(x * y);
                        }
                    }
                }
            }
        }
        if(list.isEmpty()) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
