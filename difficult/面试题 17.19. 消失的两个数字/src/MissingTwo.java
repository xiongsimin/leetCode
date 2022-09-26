/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/26
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 *
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 *
 * nums.length <= 30000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/missing-two-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int twoSum = n * (n + 1) / 2 - sum;
        int midOfTwo = twoSum / 2;
        int sumOfLostOne = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= midOfTwo) {
                sumOfLostOne += nums[i];
            }
        }
        int lostOne = (midOfTwo + 1) * midOfTwo / 2 - sumOfLostOne;
        return new int[]{lostOne, twoSum - lostOne};
    }

}
