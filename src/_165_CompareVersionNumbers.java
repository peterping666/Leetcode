public class _165_CompareVersionNumbers {
    /**
     * Time O(m + n + max(m,n)) m is the length of version1 and n is the length of version2
     * Space O(m + n)
     * @return
     */
    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] nums1 = version1.split("\\.");
            String[] nums2 = version2.split("\\.");
            int n1 = nums1.length, n2 = nums2.length;
            int i = 0, j = 0;
            while(i < n1 || j < n2) {
                int num1 = i == n1 ? 0 : Integer.valueOf(nums1[i++]);
                int num2 = j == n2 ? 0 : Integer.valueOf(nums2[j++]);
                if(num1 != num2) {
                    return num1 < num2 ? -1 : 1;
                }
            }

            return 0;
        }
    }
}
