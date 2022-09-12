import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/12
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersect {
    // 二分？+hash
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resList = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int left = 0, right = nums2.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[i] > nums2[mid]) {
                    left = mid + 1;
                } else if (nums1[i] < nums2[mid]) {
                    right = mid - 1;
                } else {
                    if (!used.contains(mid)) {
                        resList.add(nums1[i]);
                        used.add(mid);
                    } else {
                        // 从mid处往左找
                        int p = mid, q = mid;
                        boolean flag = false;
                        while (p >= 0 && nums2[p] == nums1[i]) {
                            if (!used.contains(p)) {
                                resList.add(nums1[i]);
                                used.add(p);
                                flag = true;
                                break;
                            }
                            p--;
                        }
                        if (!flag) {
                            // 从mid处往右找
                            while (q < nums2.length && nums2[q] == nums1[i]) {
                                if (!used.contains(q)) {
                                    resList.add(nums1[i]);
                                    used.add(q);
                                    flag = true;
                                    break;
                                }
                                q++;
                            }
                        }
                    }
                    break;
                }
            }
        }
        if (resList == null || resList.size() == 0) {
            return new int[0];
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    // 双指针
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p = 0, q = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] == nums2[q]) {
                res.add(nums1[p]);
                p++;
                q++;
            } else if (nums1[p] < nums2[q]) {
                p++;
            } else {
                q++;
            }
        }
        if (res.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
