package Laicode;

public class _292_StringAbbreviationMatching {
    public class Solution1 {
        public boolean match(String input, String pattern) {
            return match(input, pattern, 0, 0);
        }

        private boolean match(String input, String pattern, int inputIndex, int patternIndex) {
            if(inputIndex == input.length() && patternIndex == pattern.length()) {
                return true;
            }
            if(inputIndex >= input.length() || patternIndex >= pattern.length()) {
                return false;
            }
            if(Character.isLetter(pattern.charAt(patternIndex))) {
                if(input.charAt(inputIndex) != pattern.charAt(patternIndex)) {
                    return false;
                } else {
                    return match(input, pattern, inputIndex + 1, patternIndex + 1);
                }
            }
            int num = 0;
            while(patternIndex < pattern.length() && Character.isDigit(pattern.charAt(patternIndex))) {
                num = num * 10 + pattern.charAt(patternIndex) - '0';
                patternIndex++;
            }
            return match(input, pattern, inputIndex + num, patternIndex);
        }
    }

    public class Solution2 {
        public boolean match(String input, String pattern) {
            int si = 0;
            int ti = 0;
            while(si < input.length() && ti < pattern.length()) {
                if(pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
                    if(input.charAt(si) != pattern.charAt(ti)) {
                        return false;
                    }
                    si++;
                    ti++;
                } else {
                    int count = 0;
                    while(ti < pattern.length() && Character.isDigit(pattern.charAt(ti))) {
                        count = count * 10 + pattern.charAt(ti) - '0';
                        ti++;
                    }
                    si += count;
                }
            }
            return si == input.length() && ti == pattern.length();
        }
    }

}
