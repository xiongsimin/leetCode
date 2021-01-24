/**
 * @Author aries
 * @Data 2021-01-24
 */
public class LengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        int tempMaxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                tempMaxLen++;
            } else {
                maxLen = tempMaxLen > maxLen ? tempMaxLen : maxLen;
                tempMaxLen = 1;
            }
        }
        return maxLen;
    }
}
