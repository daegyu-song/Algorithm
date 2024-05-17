package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ5567 {
    static int n, m;
    static ArrayList<Integer>[] field;
    static int[] dist;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        field = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, -1);
    }

    static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        int sum = 0;
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {
                if (dist[y] != -1) continue;

                que.add(y);
                dist[y] = dist[x] + 1;
                if (dist[y] == 1 || dist[y] == 2) sum++;
            }
        }
        return sum;
    }

    static void pro() {
        System.out.println(bfs(1));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
