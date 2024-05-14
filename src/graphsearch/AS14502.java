package graphsearch;

import java.util.*;
import java.io.*;

public class AS14502 {
    static int N, M, B, ans;
    static int[][] field, wall;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        wall = new int[N * M][2];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = false;
                if (field[i][j] == 2) {
                    que.add(i);
                    que.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll(), y = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (field[nx][ny] != 0) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;
                que.add(nx);
                que.add(ny);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0 && !visit[i][j]) cnt++;
            }
        }
        ans = Math.max(cnt, ans);
    }

    static void recur(int idx, int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        if (idx >= B) return;

        field[wall[idx][0]][wall[idx][1]] = 1;
        recur(idx + 1, depth + 1);

        field[wall[idx][0]][wall[idx][1]] = 0;
        recur(idx + 1, depth);
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) {
                    wall[B][0] = i;
                    wall[B][1] = j;
                    B++;
                }
            }
        }

        recur(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
