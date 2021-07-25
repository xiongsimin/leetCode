import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author aries
 * @Data 2021-07-25
 * @Description 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * <p>
 *  
 * 示例 1 ：
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 * <p>
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        String res = "";
        Deque<Character> deque = new LinkedList<Character>();
        int j = 0;
        if (num.length() == 1) {
            return "0";
        }
        while (k > 0 && j < num.length()) {
            if (deque.isEmpty()) {
                deque.addLast(num.charAt(j));
                j++;
            } else {
                if (deque.getLast() > num.charAt(j)) {
                    deque.removeLast();
                    k--;
                } else {
                    deque.addLast(num.charAt(j));
                    j++;
                }
            }
        }
        //j未到最末尾，说明k=0，直接将栈中元素与剩余元素拼接即可
        if (j < num.length()) {
            while (!deque.isEmpty()) {
                res += deque.pollFirst();
            }
            res += num.substring(j);
        }
        //j到了末尾，说明序列已全部入栈，但是k可能不为0，栈中最顶上k个不需要
        else {
            while (deque.size() > k) {
                res += deque.pollFirst();
            }
        }
        if (res.length() == 0) {
            return "0";
        }
        while (res.startsWith("0")) {
            res = res.substring(1);
        }
        if (res.length() == 0) {
            return "0";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(RemoveKdigits.removeKdigits("1234567890", 9));
    }
}
