import java.util.Arrays;
import java.util.Comparator;

public class _179_LargestNumber {
    /**
     * Time O(nlogn)
     * Space O(n)
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });
        if(strs[0].charAt(0) == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
