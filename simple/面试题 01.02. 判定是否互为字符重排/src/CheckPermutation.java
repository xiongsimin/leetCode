import java.util.HashMap;
import java.util.Map;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/9/27
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if ((s1 == null && s2 == null)) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            charMap.put(s1.charAt(i), charMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            Integer integer = charMap.get(s2.charAt(i));
            if (integer == null) {
                return false;
            }
            if (integer == 1) {
                charMap.remove(s2.charAt(i));
            } else if (integer > 1) {
                charMap.put(s2.charAt(i), integer - 1);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.CheckPermutation("你爱我", "我爱你"));
    }
}
