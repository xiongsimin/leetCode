import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author aries
 * @Data 2021-02-21
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * @示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * @示例 2： 输入：s = "()[]{}"
 * 输出：true
 * @示例 3： 输入：s = "(]"
 * 输出：false
 * @示例 4： 输入：s = "([)]"
 * 输出：false
 * @示例 5： 输入：s = "{[]}"
 * 输出：true
 *  
 * @提示： 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Valid {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> relationShip = new HashMap<>();
        relationShip.put(')', '(');
        relationShip.put(']', '[');
        relationShip.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty() || !(stack.pop() == relationShip.get(s.charAt(i)))) {
                    return false;
                }
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Valid valid = new Valid();
        System.out.println(valid.isValid("()[]{}"));
    }
}
