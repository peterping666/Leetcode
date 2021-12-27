public class _165_CompareVersionNumbers {

    class Solution1 {
        public int compareVersion(String version1, String version2) {
            String[] s1 = version1.split("\\.");
            String[] s2 = version2.split("\\.");
            int i = 0, n1 = s1.length, n2 = s2.length;
            while(i < n1 || i < n2) {
                int num1 = i < n1 ? Integer.valueOf(s1[i]) : 0;
                int num2 = i < n2 ? Integer.valueOf(s2[i]) : 0;
                if(num1 > num2) {
                    return 1;
                } else if(num1 < num2) {
                    return -1;
                }
                i++;
            }
            return 0;
        }
    }

    class Solution2 {
        public int compareVersion(String version1, String version2) {
            String[] s1 = version1.split("\\.");
            String[] s2 = version2.split("\\.");
            int i = 0;
            while(i < s1.length && i < s2.length) {
                int num1 = Integer.valueOf(s1[i]);
                int num2 = Integer.valueOf(s2[i]);
                if(num1 > num2) {
                    return 1;
                } else if(num1 < num2) {
                    return -1;
                }
                i++;
            }
            while(i < s1.length) {
                if(Integer.valueOf(s1[i++]) > 0) {
                    return 1;
                }
            }
            while(i < s2.length) {
                if(Integer.valueOf(s2[i++]) > 0) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
