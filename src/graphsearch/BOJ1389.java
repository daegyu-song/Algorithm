package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ1389 {
    static int N, M;
    static ArrayList<Integer>[] field;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }

        dist = new int[N + 1];
        Arrays.fill(dist, -1);
    }

    static int bfs(int i) {
        Queue<Integer> que = new LinkedList<>();
        Arrays.fill(dist, -1);
        que.add(i);
        dist[i] = 0;
        int sum = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            sum += dist[x];

            for (int y : field[x]) {
                if (dist[y] != -1) continue;

                que.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        return sum;
    }

    static void pro() {
        int min = bfs(1), minIndex = 1;
        for (int i = 2; i <= N; i++) {
            int a = bfs(i);
            if (a < min) {
                min = a;
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
