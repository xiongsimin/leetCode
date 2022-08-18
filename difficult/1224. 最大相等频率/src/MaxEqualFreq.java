import java.util.HashMap;
import java.util.Map;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/8/18
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 *
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-equal-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxEqualFreq {
    public static int maxEqualFreq(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> xCnt = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0, res = 0;
        for (int i = 0; i < n; i++) {
            Integer iCnt = xCnt.get(nums[i]);
            xCnt.put(nums[i], iCnt == null ? 1 : iCnt + 1);

            Integer iFreq = freq.get(xCnt.get(nums[i]));
            freq.put(xCnt.get(nums[i]), iFreq == null ? 1 : iFreq + 1);
            Integer dFreq = freq.get(xCnt.get(nums[i]) - 1);
            if (dFreq != null && dFreq > 0) {
                freq.put(xCnt.get(nums[i]) - 1, dFreq - 1);
            }


            maxFreq = Math.max(maxFreq, xCnt.get(nums[i]));
            boolean flag = false;
            flag = maxFreq == 1
                    || (freq.get(maxFreq) != null && freq.get(maxFreq) == 1 && (freq.get(maxFreq) * maxFreq + (maxFreq - 1) * (freq.get(maxFreq - 1) == null ? 0 :
                    freq.get(maxFreq - 1))) == i + 1)
                    || (freq.get(1) == 1 && maxFreq * (freq.get(maxFreq) == null ?
                    0 : freq.get(maxFreq)) + 1 == i + 1);
            if (flag) {
                res = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(MaxEqualFreq.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
    }
}
