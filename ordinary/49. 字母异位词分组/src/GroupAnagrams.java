import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2023/8/8
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newStr = Arrays.toString(charArray);
            List<String> list = hash.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            hash.put(newStr, list);
        }
        List<List<String>> rsList = new ArrayList<>();
        for (String s : hash.keySet()) {
            List<String> value = hash.get(s);
            rsList.add(value);
        }
        return rsList;
    }
}
