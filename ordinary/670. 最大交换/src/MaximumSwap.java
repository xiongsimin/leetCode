/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/13
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSwap {
    public static int maximumSwap(int num) {
        char[] charArr = String.valueOf(num).toCharArray();
        int n = charArr.length;
        int idx1 = -1, idx2 = -1;
        int maxIdx = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArr[i] > charArr[maxIdx]) {
                maxIdx = i;
            } else if (charArr[i] < charArr[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 > -1) {
            swap(charArr, idx1, idx2);
            return Integer.parseInt(String.valueOf(charArr));
        }
        return Integer.parseInt(String.valueOf(charArr));
    }

    static void swap(char[] charArr, int idx1, int idx2) {
        char temp = charArr[idx1];
        charArr[idx1] = charArr[idx2];
        charArr[idx2] = temp;
    }

    public static void main(String[] args) {
        MaximumSwap.maximumSwap(2736);
    }
}
