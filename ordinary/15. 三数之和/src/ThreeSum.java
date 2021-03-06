import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author aries
 * @Data 2021-03-06
 */
public class ThreeSum {
    //第二重循环和第三重循环使用双指针nums[j]+nums[k]>-nums[i]时有指针（k）左移，否则右移
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        //第一步先将数组按升序排序
        //第二步进行3重循环寻找相加等于0的组合
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && j < nums.length - 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                while (k > j && (nums[j] + nums[k] > -nums[i])) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[k]);
                    ans.add(integers);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> ans = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ans);
    }
}
