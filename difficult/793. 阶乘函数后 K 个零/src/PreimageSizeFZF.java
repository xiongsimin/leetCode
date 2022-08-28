/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/8/28
 */
public class PreimageSizeFZF {
    public static int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public static long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (zeta(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public static long zeta(long x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = PreimageSizeFZF.preimageSizeFZF(1);
        System.out.println(i);
    }

   /* 作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/solution/jie-cheng-han-shu-hou-k-ge
    -ling-by-leetc-n6vj/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
