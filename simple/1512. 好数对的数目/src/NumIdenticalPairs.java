import java.util.HashMap;
import java.util.Map;

/**
 * @Author aries
 * @Data 2020-11-16
 * @Description 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 *  
 * @示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * @示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * @示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 *  
 * @提示： 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumIdenticalPairs {
    //注：不能直接用原始排列组合数去计算，当某个数好数对较多时，排列的值过大会导致溢出，long也不够
    //思路一：遍历数组，统计每个数重复次数，再对每个重复次数求组合数
    public int numIdenticalPairs(int[] nums) throws Exception {
        Map<Integer, Integer> recordHash = new HashMap();
        for (int num : nums) {
            if (!recordHash.containsKey(num)) {
                recordHash.put(num, 1);
            } else {
                recordHash.put(num, recordHash.get(num) + 1);
            }
        }
        int result = 0;
        for (int k : recordHash.keySet()) {
            if (recordHash.get(k) > 1) {
                result += composePlus(recordHash.get(k), 2);
            }
        }
        return result;
    }

    //排列函数
    int range(int n) throws Exception {
        if (n < 0) {
            throw new Exception("排列函数：不合法的输入");
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return n * range(n - 1);
    }

    //组合函数 m是下标  n是上标
    int compose(int m, int n) throws Exception {
        if (m < n) {
            throw new Exception("组合函数：不合法的输入");
        }
        return (range(m) / (range(n) * range(m - n)));
    }

    //升级版组合函数  注意：题目中用到的组合均为N个中2个的组合，所以int长度完全足够
    int composePlus(int m, int n) throws Exception {
        if (m < n) {
            throw new Exception("组合函数：不合法的输入");
        }
        if (n == 0 || m == n) {
            return 1;
        }
        int k = m - n;
        int result = 1;
        for (int i = m; i > k; i--) {
            result *= i;
        }
        return result / range(n);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 1, 1, 3};
        int[] nums = new int[]{1,1,1,1};
//        int[] nums = new int[]{6, 5, 1, 5, 7, 7, 9, 1, 5, 7, 1, 6, 10, 9, 7, 4, 1, 8, 7, 1, 1, 8, 6, 4, 7, 4, 10, 5, 3, 9, 10, 1, 9, 5, 5, 4, 1, 7, 4, 2, 9, 2, 6, 6, 4, 2, 10, 3, 5, 3, 6, 4, 7, 4, 6, 4, 4, 6, 3, 4, 10, 1, 10, 6, 10, 4, 9, 6, 6, 4, 8, 6, 9, 5, 4};
        NumIdenticalPairs numIdenticalPairs = new NumIdenticalPairs();
        try {
            System.out.println(numIdenticalPairs.numIdenticalPairs(nums));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //思路二：来自题解中用户 Jayceon  解题思路关键点在于：
    // 1、求组合数等价于统计某个数遍历过程中(每次遇到的次数-1)之和，例如[1,1,1,1]  的结果等于0+1+2+3=6。
    // 2、注意题目提示中数据范围1<=nums[i]<=100，数组长度也是100以内，可以直接将(某个数遇到的次数-1)根据(当前具体数字-1)作为下标存到辅助数组中，同时统计结果加上(某个数遇到的次数-1)。
    //思路非常巧妙，nb
    /*
    原作者：JayceonDu
    链接：https://leetcode-cn.com/problems/number-of-good-pairs/solution/zhe-gu-ji-shi-wo-xie-zen-yao-duo-ti-yi-lai-zui-dua/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int numIdenticalPairsPlus(int[] nums) {
        int ans = 0;
        //因为 1<= nums[i] <= 100  所以申请大小为100的数组
        //temp用来记录num的个数
        int[] temp = new int[100];
        /*
        从前面开始遍历nums
        假设nums = [1,1,1,1]
        第一遍
        temp是[0,0,0,0]
        ans+=0;
        temp[0]++;
        第二遍
        temp是[1,0,0,0]
        ans+=1;
        temp[0]++;
        第三遍
        temp=[2,0,0,0]
        ans+=2;
        temp[0]++;
        第四遍
        temp=[3,0,0,0]
        ans+=3;
        temp[0]++;
        */
        for (int num : nums) {
            /*
            这行代码可以写成
            ans+=temp[num - 1];
            temp[num - 1]++;
            */
            ans += temp[num - 1]++;
        }
        return ans;
    }

}
