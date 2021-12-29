public class _470_ImplementRand10UsingRand7 {
    class Solution {
        public int rand10() {
            int num = 40;
            while(num >= 40) {
                num = (rand7() - 1) * 7 + rand7() - 1;
            }
            return num % 10 + 1;
        }
    }

    public int rand7() {
        return 0;
    }
}

/**
 * (1) Implement rand11() using rand3():
 *
 * public int rand11() {
 *     int result = 22;
 *     while (result >= 22) {result = 3 * 3 * (rand3() - 1) + 3 * (rand3() - 1) + (rand3() - 1);}
 *     return result % 11 + 1;
 * }
 *
 * Idea: rand3() -> rand27() -> rand22 -> rand11
 * Time Comlexity: O(27/22)
 *
 * (2) Implement rand9() using rand7():
 *
 * public int rand9() {
 *     int result = 45;
 *     while (result >= 45) {result = 7 * (rand7() - 1) + (rand7() - 1);}
 *     return result % 9 + 1;
 * }
 *
 * Idea: rand7() -> rand49() -> rand45() -> rand9()
 * Time Comlexity: O(49/45)
 *
 * (3) Implement rand13() using rand6():
 *
 * public int rand13() {
 *     int result = 26;
 *     while (result >= 26) {result = 6 * (rand6() - 1) + (rand6() - 1);}
 *     return result % 13 + 1;
 * }
 *
 * Idea: rand6() -> rand36() -> rand26 -> rand13()
 * Time Comlexity: O(36/26)
 *
 */
