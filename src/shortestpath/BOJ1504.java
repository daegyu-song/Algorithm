package shortestpath;

import java.util.*;
import java.io.*;

public class BOJ1504 {
    static int n, e, v1, v2;
    static ArrayList<Info>[] field;
    static int[] dist;
    static final int INF = 200000000;

    static class Info implements Comparable<Info>{
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

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        field = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            field[x].add(new Info(y, c));
            field[y].add(new Info(x, c));
        }

        dist = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);

        PriorityQueue<Info> queue = new PriorityQueue<>();
        queue.add(new Info(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (dist[info.idx] < info.weight) continue;

            for (Info i : field[info.idx]) {

                if (dist[info.idx] + i.weight >= dist[i.idx]) continue;

                dist[i.idx] = dist[info.idx] + i.weight;
                queue.add(new Info(i.idx, dist[i.idx]));
            }
        }
        return dist[end];
    }

    static void pro() {

        int v1Tov2 = 0;
        v1Tov2 += dijkstra(1, v1);
        v1Tov2 += dijkstra(v1, v2);
        v1Tov2 += dijkstra(v2, n);

        int v2Tov1 = 0;
        v2Tov1 += dijkstra(1, v2);
        v2Tov1 += dijkstra(v2, v1);
        v2Tov1 += dijkstra(v1, n);

        System.out.println(v1Tov2 >= INF && v2Tov1 >= INF ? -1 : Math.min(v1Tov2, v2Tov1));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
