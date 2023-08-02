import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ((No javadoc))
 *
 * @author xiongsimin
 * @date 2022/12/4
 */
public class DividePlayers {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0L;
        int i = 0, j = skill.length - 1;
        long singleTeamSum = (long) skill[0] + skill[skill.length - 1];
        while (i < j) {
            long temSingleTeamSum = (long) skill[i] + skill[j];
            if (temSingleTeamSum != singleTeamSum) {
                return -1;
            }
            sum += (long) skill[0] * skill[skill.length - 1];
            i++;
            j--;
        }
        return sum;
    }

    static PriorityQueue<Integer> minRoad = new PriorityQueue<>(1);
    static int[][] visted = null;
    public static int minScore(int n, int[][] roads) {
        int[][] myRoads = new int[n][n];
        visted = new int[myRoads.length][myRoads.length];
        for (int i = 0; i < roads.length; i++) {
            myRoads[roads[i][0] - 1][roads[i][1] - 1] = roads[i][2];
        }
        dfs(0, n, myRoads, 0);
        return minRoad.peek();
    }

    static void dfs(int k, int n, int[][] myRoads, int curDistance) {
        for (int i = 1; i < myRoads.length; i++) {
            if (myRoads[k][i] <= 0) {
                continue;
            }
            if (visted[k][i] == 1||visted[i][k]==1) {
                continue;
            }
            visted[k][i] = 1;
            minRoad.offer(myRoads[k][i]);
            dfs(i, n, myRoads, curDistance + myRoads[k][i]);
        }
    }

    public static void main(String[] args) {
        List<int[]>[] grid=new ArrayList[5];
        //        DividePlayers.dividePlayers(new int[]{3,2,5,1,3,4});
        System.out.println(DividePlayers.minScore(6, new int[][]{{4, 5, 7468}, {6, 2, 7173}, {6, 3, 8365}, {2, 3, 7674}, {5, 6, 7852}
                , {1, 2, 8547}, {2, 4, 1885}, {2, 5, 5192}, {1, 3, 4065}, {1, 4, 7357}}));
    }
}
