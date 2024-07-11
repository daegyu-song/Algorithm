package shortestpath;

import java.io.*;
import java.util.*;

public class BOJ1238 {
    static class Info implements Comparable<Info> {

        int idx, weight;

        public Info(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return weight - o.weight;
        }
    }

    static int n, m, end, ans;
    static ArrayList<Info>[] field;
    static int[] dist, ansArr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        field = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            field[x].add(new Info(y, c));
        }

        dist = new int[n + 1];
        ansArr = new int[n + 1];
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Info> queue = new PriorityQueue<>();
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (dist[info.idx] < info.weight) continue;

            for (Info i : field[info.idx]) {
                if (dist[info.idx] + i.weight >= dist[i.idx]) continue;

                dist[i.idx] = dist[info.idx] + i.weight;
                queue.add(new Info(i.idx, dist[i.idx]));
            }
        }
    }

    static void pro() {
        dijkstra(end);
        for (int i = 1; i <= n; i++) {
            ansArr[i] += dist[i];
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
            ansArr[i] += dist[end];
        }

        for (int i = 1; i <= n; i++) {
            if (i == end) continue;
            ans = Math.max(ans, ansArr[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
