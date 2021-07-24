/**
 * @Author aries
 * @Data 2021-07-24
 * @Description 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * <p>
 * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 * <p>
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * <p>
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *  
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度完成此题?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleMaxLength {

    public enum STATE {
        STATE_BEGIN(0),
        STATE_UP(1),
        STATE_DOWN(2);
        private final int state;

        STATE(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }

        public static STATE getEnumByState(int state) {
            for (STATE val : STATE.values()) {
                if (val.getState() == state) {
                    return val;
                }
            }
            return null;
        }
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 1;
        STATE state = STATE.STATE_BEGIN;
        for (int i = 1; i < nums.length; i++) {
            switch (state) {
                case STATE_BEGIN:
                    if (nums[i] > nums[i - 1]) {
                        res++;
                        state = STATE.STATE_UP;
                    } else if (nums[i] < nums[i - 1]) {
                        res++;
                        state = STATE.STATE_DOWN;
                    }
                    break;
                case STATE_UP:
                    if (nums[i] < nums[i - 1]) {
                        res++;
                        state = STATE.STATE_DOWN;
                    }
                    break;
                case STATE_DOWN:
                    if (nums[i] > nums[i - 1]) {
                        res++;
                        state = STATE.STATE_UP;
                    }
                    break;
            }
        }
        return res;
    }


    public int wiggleMaxLength1(int[] nums) {
        //dp   ups[i]代表到下标i为止以0~i中某个数为结尾的数字为最后一个元素的上升摆动子序列（最后一段是上升序列的摆动序列）的最大长度，dowms[i]同理
        int[] ups = new int[nums.length];
        int[] downs = new int[nums.length];
        ups[0] = 1;
        downs[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ups[i] = ups[i - 1];
            } else {
                ups[i] = max(ups[i - 1], downs[i - 1] + 1);
            }
            if (nums[i] >= nums[i - 1]) {
                downs[i] = downs[i - 1];
            } else {
                downs[i] = max(downs[i - 1], ups[i - 1] + 1);
            }
        }
        return max(ups[nums.length - 1], downs[nums.length - 1]);
    }

    public int wiggleMaxLength3(int[] nums) {
        //dp优化
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                down = max(up + 1, down);
            } else if (nums[i] > nums[i - 1]) {
                up = max(down + 1, up);
            }
        }
        return max(up, down);
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }


    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        System.out.println(wiggleMaxLength.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
    }
}
