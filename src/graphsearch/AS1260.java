package graphsearch;

import java.util.*;
import java.io.*;

public class AS1260 {
    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(" ");
        for (int y : adj[x]) {
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
            for (int y : adj[x]) {
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
