public class _9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int rev = 0;
        while(x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return num == rev;
    }
}
