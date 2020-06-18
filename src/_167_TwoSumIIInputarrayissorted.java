public class _167_TwoSumIIInputarrayissorted {
    /**
     * Time O(n)
     * Space O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(target == sum) return new int[]{left + 1, right + 1};
            if(target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
