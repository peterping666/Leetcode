public class _67_AddBinary {
    /**
     * Time O(n)
     * Space O(1)
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        while(indexA >= 0 || indexB >= 0) {
            int oprand1 = 0;
            int oprand2 = 0;
            if(indexA >= 0) {
                oprand1 = a.charAt(indexA) - '0';
                indexA--;
            }
            if(indexB >= 0) {
                oprand2 = b.charAt(indexB) - '0';
                indexB--;
            }
            int sum = oprand1 + oprand2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
