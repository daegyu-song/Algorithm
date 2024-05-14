package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ1012 {
    static int M, N, K;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] field;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        field = new int[N][M];
        for (int j = 0; j < K; j++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
            field[x][y] = 1;
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visit[nx][ny]) continue;
            if (field[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && field[i][j] == 1) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}
