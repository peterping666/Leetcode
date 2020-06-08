import java.util.ArrayList;
import java.util.List;

public class _66_PlusOne {
    /**
     * Time O(n)
     * Space O(n)
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            list.add(sum % 10);
        }
        if(carry > 0) list.add(carry);
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(list.size() - i - 1);
        }
        return ans;
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
