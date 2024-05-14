package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ14502 {
    static int N, M;
    static int[][] field;
    static boolean[][] visit;
    static int ans = -1;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N][M];
    }

    static void count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        ans = Math.max(cnt, ans);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (field[nx][ny] != 0) continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void recur(int depth) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visit[i][j]) continue;
                    if (field[i][j] != 2) continue;

                    dfs(i, j);
                }
            }

            count();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visit[i][j] = false;
                }
            }

        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 0) {
                        field[i][j] = 1;
                        recur(depth + 1);
                        field[i][j] = 0;
                    }
                }
            }
        }
    }

    static void pro() {
        recur(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
