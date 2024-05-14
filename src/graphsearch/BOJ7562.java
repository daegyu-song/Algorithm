package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ7562 {
    static int w, h;
    static int[][] field;
    static boolean[][] visit;
    static int[][] dir =  {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        field = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[h][w];
    }

    static void dfs(int a, int b) {
        visit[a][b] = true;

        for (int i = 0; i < dir.length; i++) {
            int na = a + dir[i][0];
            int nb = b + dir[i][1];

            if (na < 0 || nb < 0 || na >= h || nb >= w) continue;
            if (visit[na][nb]) continue;
            if (field[na][nb] == 0) continue;
            dfs(na, nb);
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && field[i][j] == 1) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (w == 0 && h == 0) break;
            pro();
        }
    }
}
