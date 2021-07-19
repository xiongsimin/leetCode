import java.util.Stack;

/**
 * @Author aries
 * @Data 2021-07-19
 * @Description 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Calculate {
    public int calculate(String s) {
        //操作数栈
        Stack<Integer> dataStack = new Stack<>();
        //运算符栈
        Stack<Character> symbolStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            //操作数，考虑特殊情况（负数）
            else if ('0' <= s.charAt(i) && '9' >= s.charAt(i)) {
                String data = String.valueOf(s.charAt(i));
                while (i < s.length() - 1 && '0' <= s.charAt(i + 1) && '9' >= s.charAt(i + 1)) {
                    data += s.charAt(i + 1);
                    i++;
                }
                dataStack.push(Integer.parseInt(data));
                if (!symbolStack.isEmpty() && (symbolStack.peek() == '-' || symbolStack.peek() == '+')) {
                    //取数字栈顶两个数字做运算
                    int data1 = dataStack.pop();
                    int data2 = dataStack.pop();
                    if ('+' == symbolStack.peek()) {
                        //将结果重新入栈
                        dataStack.push(data2 + data1);
                    } else {
                        dataStack.push(data2 - data1);
                    }
                    symbolStack.pop();
                }
            }
            //运算符
            else if (')' == s.charAt(i)) {
                while (symbolStack.peek() == '('||(!symbolStack.isEmpty()&&(symbolStack.peek() == '-' || symbolStack.peek() == '+'))) {
                    if('('==s.charAt(i)){
                        //“(”出栈
                        symbolStack.pop();
                        break;
                    }
                    char symbol = symbolStack.pop();
                    //取数字栈顶两个数字做运算
                    int data1 = dataStack.pop();
                    int data2 = dataStack.pop();
                    if ('+' == symbol) {
                        //将结果重新入栈
                        dataStack.push(data2 + data1);
                    } else {
                        dataStack.push(data2 - data1);
                    }
                }

            } else {
                if('-'==s.charAt(i)){
                    //往前读取，遇到的第一个有效符号为数字，则当做减号处理，否则当做负号处理
                    int j = i - 1;
                    boolean isNegativeSymbol = true;
                    while (j >= 0) {
                        if (' ' == s.charAt(j)) {
                            j--;
                            continue;
                        }
                        //必是负号
                        else if ('(' == s.charAt(j)) {
                            break;
                        }
                        //必是减号
                        else if (')' == s.charAt(j) || ('0' <= s.charAt(j) && '9' >= s.charAt(j))) {
                            isNegativeSymbol = false;
                            break;
                        }
                        //循环结束，前面没有了，则也是负号
                    }
                    if (isNegativeSymbol) {
                        dataStack.push(0);
                    }
                }
                symbolStack.push(s.charAt(i));
            }
        }
        //做栈中剩余运算
        while (!symbolStack.isEmpty()) {
            char symbol = symbolStack.pop();
            //取数字栈顶两个数字做运算
            int data1 = dataStack.pop();
            int data2 = dataStack.pop();
            if ('+' == symbol) {
                //将结果重新入栈
                dataStack.push(data2 + data1);
            } else {
                dataStack.push(data2 - data1);
            }
        }
        return dataStack.pop();
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("1-1"));
    }
}
