/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/25
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9
 * 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *  
 *
 * 示例：
 *
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *  
 *
 * 提示：
 *
 * N 的取值范围是 [1, 10000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotated-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotatedDigits {
    public int rotatedDigits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (rotateDigit(i) == -1) {
                ans[i] = ans[i - 1];
                continue;
            }
            if (rotateDigit(i) != i) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i - 1];
            }
        }
        return ans[n];
    }

    int rotateDigit(int x) {
        int rs = 0;
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int temp = x % 10;
            if (temp == 3 || temp == 4 || temp == 7) {
                return -1;
            }
            switch (temp) {
                case 2:
                    temp = 5;
                    break;
                case 5:
                    temp = 2;
                    break;
                case 6:
                    temp = 9;
                    break;
                case 9:
                    temp = 6;
                    break;
                default:
            }
            sb.insert(0, String.valueOf(temp));
            x /= 10;
        }
        for (int i = 0; i < sb.length(); i++) {
            rs = rs * 10 + Integer.parseInt(String.valueOf(sb.charAt(i)));
        }
        return rs;
    }

    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        int i = rotatedDigits.rotatedDigits(10);
        System.out.println(i);
    }
}
