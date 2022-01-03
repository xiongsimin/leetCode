/**
 * @author xiongsm
 * @Date 2022-01-03
 * @Description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsUnique {

    // 方法一：hash
    int[] arr = new int[128];

    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        for (int i = 0; i < astr.length(); i++) {
            if (arr[astr.charAt(i)] == 1) {
                return false;
            }
            arr[astr.charAt(i)] = 1;
        }
        return true;
    }

    // 方法二：位运算  不需要额外空间
    public static boolean isUnique1(String astr) {
        int aa = 0;
        int cc = 1;
        for (int i = 0; i < astr.length(); i++) {
            char t = astr.charAt(i);
            int offset = t - 'a';

            int bb = cc << offset;
            if ((aa & bb) != 0) {
                return false;
            }
            aa |= bb;

        }

        return true;
    }
}
