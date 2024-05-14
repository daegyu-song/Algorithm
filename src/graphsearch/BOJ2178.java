package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ2178 {
    static int N, M;
    static String[] field;
    static boolean[][] visit;
    static int[][] dist;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            field[i] = st.nextToken();
        }
        visit = new boolean[N][M];
        dist = new int[N][M];
        dist[0][0] = 1;
    }

    static void bfs(int i, int j) {
        Queue<Integer> que = new LinkedList<>();
        que.add(i);
        que.add(j);
        visit[i][j] = true;

        while(!que.isEmpty()) {
            int x = que.poll(), y = que.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (field[nx].charAt(ny) == '0') continue;

                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
            }
        }

    }

    static void pro() {
        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
