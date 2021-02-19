/**
 * @author xiongsm
 * @Date 2021-02-04
 * @Description 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * @进阶：你能设计一个时间复杂度为 O(log ( m + n)) 的算法解决此问题吗？
 * @示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * @示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * @示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * @示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * @示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * @提示： nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianSortedArrays {
    public static void main(String[] args) {
        MedianSortedArrays medianSortedArrays = new MedianSortedArrays();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        System.out.println(medianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //数组一为空
        if (len1 == 0) {
            if (len2 % 2 != 0) {
                return nums2[len2 / 2];
            } else {
                return (double) (nums2[(len2 - 1) / 2] + nums2[(len2 - 1) / 2 + 1]) / 2;
            }
        }
        //数组二为空
        else if (len2 == 0) {
            if (len1 % 2 != 0) {
                return nums1[len1 / 2];
            } else {
                return (double) (nums1[(len1 - 1) / 2] + nums1[(len1 - 1) / 2 + 1]) / 2;
            }
        }
        //均不为空,借助辅助数组
        int[] nums3 = new int[len1 + len2];
        int i = 0;
        int j = 0;
        while (i + j < (len1 + len2) / 2 + 1) {
            //数组二元素入辅助数组
            if (i == len1 || (j < len2 && nums1[i] >= nums2[j])) {
                nums3[i + j] = nums2[j];
                j++;
            }
            //数组一元素入辅助数组
            else if (j == len2 || (i < len1 && nums1[i] < nums2[j])) {
                nums3[i + j] = nums1[i];
                i++;
            }
        }
        if ((len1 + len2) % 2 != 0) {
            return nums3[(len1 + len2) / 2];
        } else {
            return (double) (nums3[(len1 + len2 - 1) / 2] + nums3[(len1 + len2 - 1) / 2 + 1]) / 2;
        }
    }
}
