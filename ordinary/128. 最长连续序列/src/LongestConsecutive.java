import java.util.HashSet;
import java.util.Set;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2023/8/10
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int len = 1;
            while (set.contains(++num)) {
                len++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
