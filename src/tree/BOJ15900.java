package tree;

import java.util.*;
import java.io.*;

public class BOJ15900 {
    static int N, ans;
    static ArrayList<Integer>[] field;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
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

            for (int y : field[x]) {
                if (dist[y] != -1) continue;

                que.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void reaf() {
        for (int i = 1; i <= N; i++) {
            if (field[i].size() == 1) {
                ans += dist[i];
            }
        }
    }

    static void pro() {
        bfs(1);
        reaf();
        System.out.println(ans % 2 != 0 ? "Yes" : "No");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
