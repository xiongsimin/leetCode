import java.util.Arrays;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/4
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 *
 * 注意 这个数列必须是 严格 递增的。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *  
 *
 * 提示: 
 *
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 * 相关标签
 *
 * Java
 *
 *
 *
 * 作者：FennelDumplings
 * 链接：https://leetcode.cn/leetbook/read/dynamic-programming-1-plus/5o6mrv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindNumberOfLIS {
    // 动态规划解法
    // 假设对于以 nums[i] 结尾的序列，我们知道最长序列的长度 length[i]，以及具有该长度的序列的 count[i]。
    //对于每一个 i<j 和一个 A[i]<A[j]，我们可以将一个 A[j] 附加到以 A[i] 结尾的最长子序列上。
    //如果这些序列比 length[j] 长，那么我们就知道我们有count[i] 个长度为 length 的序列。如果这些序列的长度与 length[j] 相等，那么我们就知道现在有 count[i] 个额外的序列（即
    // count[j]+=count[i]）。
    //
    //作者：力扣 (LeetCode)
    //链接：https://leetcode.cn/leetbook/read/dynamic-programming-1-plus/5o6mrv/?discussion=FF8XLP
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengths = new int[n];
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        Arrays.fill(lengths, 1);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                lengths[i] = 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[i] <= lengths[j]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }
        int maxLen = 0;
        // 找出最大长度
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(lengths[i], maxLen);
        }
        int res = 0;
        // 计算最大长度的个数
        for (int j = 0; j < n; j++) {
            if (lengths[j] == maxLen) {
                res += counts[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindNumberOfLIS.findNumberOfLIS(new int[]{1, 3, 5, 4, 7});
    }
}
