package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ7569 {
    static int M, N, H, ans;
    static int[][][] field, dist;
    static int[][] dir = {{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        field = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    field[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dist = new int[H][N][M];
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    dist[i][j][k] = -1;
                    if (field[i][j][k] == 1) {
                        que.add(i);
                        que.add(j);
                        que.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll(), y = que.poll(), z = que.poll();

            for (int i = 0; i < 6; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                int nz = z + dir[i][2];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= H || ny >= N || nz >= M) continue;
                if (dist[nx][ny][nz] != -1) continue;
                if (field[nx][ny][nz] == -1) continue;

                que.add(nx);
                que.add(ny);
                que.add(nz);
                dist[nx][ny][nz] = dist[x][y][z] + 1;
            }
        }
    }

    static int out() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(field[i][j][k] == 0) {
                        if (dist[i][j][k] == -1) return -1;
                        ans = Math.max(ans, dist[i][j][k]);
                    }
                }
            }
        }
        return ans;
    }

    static void pro() {
        bfs();

        System.out.println(out());
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
