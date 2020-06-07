import java.util.List;

public class _422_ValidWordSquare {
    /**
     * Time O(n * max(word length))
     * Space O(1)
     * @param words
     * @return
     */
    public boolean validWordSquare(List<String> words) {
        for(int i = 0; i < words.size(); i++) {
            for(int j = 0; j < words.get(i).length(); j++) {
                if(j >= words.size() || i >= words.get(j).length()) return false;
                if(words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
            }
        }
        return true;
    }
}
