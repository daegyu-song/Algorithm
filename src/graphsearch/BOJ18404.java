package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ18404 {
    static int N, M, startX, startY;
    static int[][] field, dist;
    static int[][] dir = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
    }

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(startX);
        que.add(startY);

        while(!que.isEmpty()) {
            int a = que.poll(), b = que.poll();

            for (int i = 0; i < 8; i++) {
                int na = a + dir[i][0];
                int nb = b + dir[i][1];
                if (na < 1 || nb < 1 || na > N || nb > N) continue;
                if (dist[na][nb] != 0) continue;

                que.add(na);
                que.add(nb);
                dist[na][nb] = dist[a][b] + 1;
            }

        }
    }

    static void pro() throws IOException {
        bfs();

        while(M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.print(dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
