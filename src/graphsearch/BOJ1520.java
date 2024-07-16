package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ1520 {
    static int m, n;
    static int[][] field, dp;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        field = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    static int dfs(int x, int y) {

        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int k = 0; k < dir.length; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) continue;

            if (field[nx][ny] < field[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }

    static void pro() {

        System.out.println(dfs(0, 0));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
