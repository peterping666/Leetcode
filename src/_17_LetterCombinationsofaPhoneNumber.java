import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_LetterCombinationsofaPhoneNumber {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.equals("")) return list;
        helper(list, 0, digits, new StringBuilder());
        return list;
    }

    private void helper(List<String> list, int idx, String digits, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String str = phone.get(digits.charAt(idx));
        for(int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            helper(list, idx + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
