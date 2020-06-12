public class _43_MultiplyStrings {
    /**
     * Time O(n * m)
     * Space O(n + m)
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int[] product = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int p1 = num1.charAt(i) - '0';
                int p2 = num2.charAt(j) - '0';
                int sum = p1 * p2 + product[i + j + 1];
                product[i + j + 1] = sum % 10;
                product[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : product) {
            if(sb.length() == 0 && num == 0) continue;
            sb.append(num);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
