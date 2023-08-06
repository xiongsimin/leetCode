import java.util.ArrayList;
import java.util.List;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2023/8/6
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> row0 = new ArrayList<>();
        row0.add(1);
        rs.add(row0);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    row.add(rs.get(i - 1).get(j));
                    continue;
                }
                if (j == i) {
                    row.add(rs.get(i - 1).get(j - 1));
                    continue;
                }
                row.add(rs.get(i - 1).get(j) + rs.get(i - 1).get(j - 1));
            }
            rs.add(row);
        }
        return rs;
    }
}
