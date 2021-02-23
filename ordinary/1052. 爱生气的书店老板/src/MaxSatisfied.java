/**
 * @author xiongsm
 * @Date 2021-02-23
 * @Description 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 * @示例： 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * @解释： 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 * @提示： 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSatisfied {
    //思路一：滑动窗口，将窗口中的grumpy[k]置0，依次求出滑动过程中的满意值，再取最大值
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = 0;
        if (customers.length != grumpy.length) {
            return -1;
        }
        //营业时长
        int len = customers.length;
        //滑动窗口左边界
        int leftCur = 0;
        //滑动窗口右边界
        int rightCur = leftCur + X - 1;
        //一直保持不生气即可
        if (X > len) {
            rightCur = len - 1;
        }
        while (rightCur <= len) {
            int sum = 0;
            for (int i = 0; i < len; i++) {
                if (i >= leftCur && i <= rightCur) {
                    sum += customers[i];
                } else {
                    sum += customers[i] * (1 - grumpy[i]);
                }
            }
            ans = sum > ans ? sum : ans;
            leftCur++;
            rightCur++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.println(maxSatisfied.maxSatisfied(customers, grumpy, X));
    }
}
