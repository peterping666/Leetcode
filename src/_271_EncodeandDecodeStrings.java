import java.util.ArrayList;
import java.util.List;

public class _271_EncodeandDecodeStrings {
    /**
     * Time O(n)
     * Space O(n)
     * @param strs
     * @return
     */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodeStr = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            encodeStr.append(strs.get(i).length()).append(":").append(strs.get(i));
        }
        return encodeStr.toString();
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param s
     * @return
     */
    // Decodes a single string to a list of strings.
    public List<String> decode1(String s) {
        List<String> decodeStr = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int len = 0;
            while(Character.isDigit(s.charAt(i))) {
                len = len * 10 + (s.charAt(i) - '0');
                i++;
            }
            i++;
            decodeStr.add(s.substring(i, i + len));
            i += len;
        }
        return decodeStr;
    }

    public List<String> decode2(String s) {
        List<String> decodeStr = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int dilimiter = s.indexOf(':', i);
            int len = Integer.parseInt(s.substring(i, dilimiter));
            decodeStr.add(s.substring(dilimiter + 1, dilimiter + 1 + len));
            i = dilimiter + 1 + len;
        }
        return decodeStr;
    }
}
