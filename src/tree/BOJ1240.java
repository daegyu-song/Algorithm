package tree;

import java.util.*;
import java.io.*;

public class BOJ1240 {
    static int N, M;
    static int[][] field;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new int[N + 1][N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
            field[x][y] = z;
            field[y][x] = z;
        }

        dist = new int[N + 1];
        Arrays.fill(dist, -1);
    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int i = 1; i <= N; i++) {
                if (field[x][i] == 0) continue;
                if (dist[i] != -1) continue;

                que.add(i);
                dist[i] = dist[x] + field[x][i];
            }
        }
    }

    static void pro() throws IOException {
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bfs(Integer.parseInt(st.nextToken()));
            sb.append(dist[Integer.parseInt(st.nextToken())]).append("\n");
            Arrays.fill(dist, -1);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
