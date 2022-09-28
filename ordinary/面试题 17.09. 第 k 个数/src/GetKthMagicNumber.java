import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/28
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        int[] fac = new int[]{3, 5, 7};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        set.add(1L);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            long cur = heap.poll();
            ans = (int) cur;
            for (int f : fac) {
                long fx = cur * f;
                if (set.add(fx)) {
                    heap.offer(fx);
                }
            }
        }
        return ans;
    }
}
