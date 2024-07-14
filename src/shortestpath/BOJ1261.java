package shortestpath;

import java.util.*;
import java.io.*;

public class BOJ1261 {
    static int n, m, ans;
    static int[][] field;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Info implements Comparable<Info>{
        int x, y, dist;

        public Info(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o) {
            return dist - o.dist;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                field[i][j] = str.charAt(j) - 48;
            }
        }

        visit = new boolean[n][m];
    }

    static void bfs() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0, 0));
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.x == n - 1 && info.y == m - 1) {
                System.out.println(info.dist);
                return;
            }

            for (int k = 0; k < dir.length; k++) {
                int nx = info.x + dir[k][0];
                int ny = info.y + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue;

                visit[nx][ny] = true;

                if (field[nx][ny] == 1) {
                    pq.add(new Info(nx, ny, info.dist + 1));
                } else {
                    pq.add(new Info(nx, ny, info.dist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }
}
