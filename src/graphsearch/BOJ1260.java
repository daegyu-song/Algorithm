package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ1260 {
    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");
        for (int y = 1; y <= N; y++) {
            if (adj[x][y] == 0) continue;
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            sb.append(x).append(" ");
            for (int y = 1; y <= N; y++) {
                if (adj[x][y] == 0) continue;
                if (visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        Arrays.fill(visit, false);
        bfs(V);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
