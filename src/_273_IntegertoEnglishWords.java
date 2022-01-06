public class _273_IntegertoEnglishWords {
    class Solution {
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        public String numberToWords(int num) {
            if (num == 0)
                return "Zero";

            return helper(num).trim();
        }

        private String helper(int num) {
            if (num >= 1000000000) {
                int val = num / 1000000000;
                int remain = num % 1000000000;
                if(remain == 0) {
                    return helper(val) + " Billion";
                } else {
                    return (helper(val) + " Billion " + helper(remain));
                }
            }
            if (num >= 1000000) {
                int val = num / 1000000;
                int remain = num % 1000000;
                if(remain == 0) {
                    return helper(val) + " Million";
                } else {
                    return (helper(val) + " Million " + helper(remain));
                }
            }
            if (num >= 1000) {
                int val = num / 1000;
                int remain = num % 1000;
                if(remain == 0) {
                    return helper(val) + " Thousand";
                } else {
                    return (helper(val) + " Thousand " + helper(remain));
                }
            }
            if (num >= 100) {
                int val = num / 100;
                int remain = num % 100;
                if(remain == 0) {
                    return helper(val) + " Hundred";
                } else {
                    return (helper(val) + " Hundred " + helper(remain));
                }
            }
            if (num >= 20) {
                int val = num / 10;
                int remain = num % 10;
                if(remain == 0) {
                    return tens[num / 10];
                } else {
                    return tens[num / 10] + " " + helper(num % 10);
                }
            }
            return ones[num];
        }
    }
}
