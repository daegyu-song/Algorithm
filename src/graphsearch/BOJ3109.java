package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ3109 {
    static int r, c, ans;
    static String[] field;
    static boolean[][] visit;
    static boolean flag;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        field = new String[r];
        for (int i = 0; i < r; i++) {
            field[i] = br.readLine();
        }

        visit = new boolean[r][c];
    }

    static void dfs(int i, int j) {
        visit[i][j] = true;

        if (j == c - 1) {
            ans++;
            flag = true;
            return;
        }

        for (int k = 0; k < dir.length; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];

            if (ni < 0 || nj < 0 || ni > r - 1 || nj > c - 1) continue;
            if (visit[ni][nj]) continue;
            if (field[ni].charAt(nj) == 'x') continue;

            dfs(ni, nj);
            if (flag) return;
        }
    }

    static void pro() {
        for (int i = 0; i < r; i++) {
            flag = false;
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
