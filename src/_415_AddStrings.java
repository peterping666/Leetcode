public class _415_AddStrings {
    /**
     * Time O(n)
     * Space O(n)
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int operand1 = 0;
            int operand2 = 0;
            if(i >= 0) {
                operand1 = num1.charAt(i--) - '0';
            }
            if(j >= 0) {
                operand2 = num2.charAt(j--) - '0';
            }
            int sum = operand1 + operand2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
