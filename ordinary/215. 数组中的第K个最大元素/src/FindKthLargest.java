import java.util.Random;

/**
 * @Author aries
 * @Data 2021-07-22
 * @Description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        //第k大的数即是正序排列后下标是length-k的数
        return quickSelectSort(nums, nums.length - k, 0, nums.length - 1);
    }

    int quickSelectSort(int[] nums, int q, int left, int right) {
        int index = randomSort(nums, left, right);
        if (index == q) {
            return nums[q];
        } else {
            return q < index ? quickSelectSort(nums, q, left, index - 1) : quickSelectSort(nums, q, index + 1, right);
        }
    }

    int randomSort(int[] nums, int left, int right) {
        int x = random.nextInt(right - left + 1) + left;
        return partition(nums, left, x, right);
    }

    int partition(int[] nums, int left, int x, int right) {
        swap(nums, x, right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[right]) {
                swap(nums, ++i, j);
            }
        }
        swap(nums,++i,right);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int test() {
        return random.nextInt(2);
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3,2,1,5,6,4},2));
//        System.out.println(findKthLargest.test());
    }
}
