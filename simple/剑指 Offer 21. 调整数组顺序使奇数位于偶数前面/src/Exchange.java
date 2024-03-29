/**
 * @Author aries
 * @Data 2021-08-08
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (right <= 1) {
            return nums;
        }
        while (left < right) {
            if ((nums[left] & 1) == 0 && (nums[right] & 1) == 1) {
                swap(nums, left, right);
                left++;
                right--;
            } else {
                if ((nums[left] & 1) == 1) {
                    left++;
                }
                if ((nums[right] & 1) == 0) {
                    right--;
                }
            }
        }
        return nums;
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int a = 1;
        a = a & 2;
    }
}
