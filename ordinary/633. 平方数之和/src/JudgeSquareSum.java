/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/12
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            long sq1 = (long) left * left;
            long sq2 = (long) right * right;
            if ((long) c - sq2 == sq1) {
                return true;
            } else if ((long) c - sq2 > sq1) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
