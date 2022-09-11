import java.util.Arrays;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/11
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *  
 *
 * 提示：
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-n-and-its-double-exist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckIfExist {
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                int left = i + 1, right = len - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int doubleA = 2 * arr[i];
                    if (doubleA == arr[mid]) {
                        return true;
                    } else if (doubleA > arr[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else {
                int left = 0, right = i - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int doubleA = 2 * arr[i];
                    if (doubleA == arr[mid]) {
                        return true;
                    } else if (doubleA > arr[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfExist.checkIfExist(new int[]{-766, 259, 203, 601, 896, -226, -844, 168, 126, -542, 159, -833, 950,
                -454, -253, 824, -395, 155, 94, 894, -766, -63, 836, -433, -780, 611, -907, 695, -395, -975, 256, 373
                , -971, -813, -154, -765, 691, 812, 617, -919, -616, -510, 608, 201, -138, -669, -764, -77, -658, 394
                , -506, -675, 523});
    }
}
