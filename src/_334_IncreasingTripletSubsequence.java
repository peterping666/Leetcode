public class _334_IncreasingTripletSubsequence {
    /**
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= min) min = num;
            else if(num <= secMin) secMin = num;
            else return true;
        }
        return false;
    }
}
