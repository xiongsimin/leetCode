import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author aries
 * @Data 2020-11-09
 */
public class LongestStr {
    //解题思路：
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int biggestLength = 0;
        int i = 0;
        while (i < len - 1) {
            int j = i + 1;
            Set<String> hashSet = new HashSet<String>();
            hashSet.add(String.valueOf(s.charAt(i)));
            while (j < len) {
                if (hashSet.contains(String.valueOf(s.charAt(j)))) {
                    biggestLength = (j - i) > biggestLength ? (j - i) : biggestLength;
                    i++;
                    break;
                } else {
                    hashSet.add(String.valueOf(s.charAt(j)));
                    j++;
                    if (j == len) {
                        biggestLength = (j - i) > biggestLength ? (j - i) : biggestLength;
                        i = len - 1;
                        break;
                    }
                }
            }

        }
        return biggestLength;
    }

    public static void main(String[] args) {
        LongestStr longestStr = new LongestStr();
        System.out.println(longestStr.lengthOfLongestSubstring("asljlj"));
    }
}
