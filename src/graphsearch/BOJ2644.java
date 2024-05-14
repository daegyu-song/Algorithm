package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ2644 {
    static int N, M, start, end;
    static ArrayList<Integer>[] field;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        field = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }

        Arrays.fill(dist, -1);
    }

    static void dfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {
                if (dist[y] != -1) continue;

                que.add(y);
                dist[y] = dist[x] + 1;
            }
        }

    }

    static void pro() {
        dfs(start);

        System.out.println(dist[end]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
