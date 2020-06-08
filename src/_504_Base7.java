public class _504_Base7 {

    /**
     * Time O(logn)
     * Space O(logn)
     * @param n
     * @return
     */
    public String convertToBase71(int n) {
        if (n < 0) return "-" + convertToBase71(-n);
        if (n < 7) return Integer.toString(n);
        return convertToBase71(n / 7) + Integer.toString(n % 7);
    }


    /**
     * Time O(logn)
     * Space O(1)
     * @param num
     * @return
     */
    public String convertToBase72(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";
        String sign = num > 0 ? "" : "-";
        num = Math.abs(num);
        while(num != 0) {
            int remainder = num % 7;
            num /= 7;
            sb.append(remainder);
        }
        sb.append(sign);
        return sb.reverse().toString();
    }
}
