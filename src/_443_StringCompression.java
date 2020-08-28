public class _443_StringCompression {
    /**
     * Time O(n)
     * Space O(1)
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int count = 1;
        int index = 0;
        for(int i = 0; i < chars.length; i++) {
            if(i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[index++] = chars[i];
                if(count != 1) {
                    String countStr = String.valueOf(count);
                    count = 1;
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[index++] = countStr.charAt(j);
                    }
                }
            } else {
                count++;
            }
        }
        return index;
    }
}
