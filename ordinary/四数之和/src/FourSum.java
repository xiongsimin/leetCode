import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/11/22
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if ((long) nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;

                        while (left < right) {
                            if (nums[left] == nums[left - 1]) {
                                left++;
                            } else {
                                break;
                            }
                        }
                        right--;
                        while (right > left) {
                            if (nums[right] == nums[right + 1]) {
                                right--;
                            } else {
                                break;
                            }
                        }
                    } else if ((long) nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = FourSum.fourSum(new int[]{-3, -1, 0, 2, 4, 5}, 1);
        System.out.println(lists);
    }
}
