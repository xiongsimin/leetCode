import java.util.HashMap;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/10/23
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *  
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MminWindow {
    public String minWindow(String s, String t) {
        int resNum = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        int validInWindow = 0;
        int targetNum = 0;
        for (int i = 0; i < t.length(); i++) {
            if (target.get(t.charAt(i)) == null) {
                targetNum++;
            }
            char c = t.charAt(i);
            Integer tNum = target.getOrDefault(c, 0);
            target.put(c, tNum + 1);

        }
        while (right < s.length()) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            if (window.get(s.charAt(right)).equals(target.getOrDefault(s.charAt(right), 0))) {
                validInWindow++;
            }
            while (validInWindow == targetNum) {
                if ((right - left + 1) < resNum) {
                    resNum = right - left + 1;
                    start = left;
                }
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (window.get(s.charAt(left)) == (target.getOrDefault(s.charAt(left), 0) - 1)) {
                    validInWindow--;
                }
                left++;
            }
            right++;
        }
        return resNum == Integer.MAX_VALUE ? "" : s.substring(start, start + resNum);
    }

}
