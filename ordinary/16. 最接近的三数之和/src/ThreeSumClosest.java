/**
 * @Author aries
 * @Data 2021-03-31
 * @Description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * @示例： 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * @解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * @提示： 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //先排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        int ans = nums[0] + nums[1] + nums[2];
        //三层循环遍历三数之和并与target比较
        for (int first = 0; first < nums.length - 2; first++) {
            for (int second = first + 1; second < nums.length - 1; second++) {
                int third = second+1;
                while (third < nums.length) {
                    int curSum = nums[first] + nums[second] + nums[third];
                    ans = Math.abs(ans - target) > Math.abs(curSum - target) ? curSum : ans;
                    //正好等于target，直接得到答案
                    if (ans - target == 0) {
                        return ans;
                    }
                    //第三层循环中，如果上个结果比target小，且这个结果比target大，往后肯定与target相差越来越大
                    else if (third > second + 1 && nums[first] + nums[second] + nums[third] - target < 0 && nums[first] + nums[second] + nums[third - 1] - target > 0) {
                        break;
                    }
                    third++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}
