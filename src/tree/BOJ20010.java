package tree;

import java.io.*;
import java.util.*;

public class BOJ20010 {
    static class Info implements Comparable<Info>{
        int from, to, value;

        public Info(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this. value = value;
        }

        public Info(int to, int value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return value - o.value;
        }
    }

    static Queue<Info> queue = new PriorityQueue<>();
    static ArrayList<Info>[] field;
    static int[] parent;
    static boolean[] visit;
    static int n, k, start;
    static long first, second;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            queue.add(new Info(x, y, c));
        }

        field = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            field[i] = new ArrayList<>();
        }

        parent = new int[n];
        visit = new boolean[n];
    }

    static void kruskal() {
        Arrays.setAll(parent, i -> i);

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            int rx = find(info.from);
            int ry = find(info.to);

            if (rx != ry) {
                union(info.to,info.from);
                first += info.value;
                field[info.to].add(new Info(info.from, info.value));
                field[info.from].add(new Info(info.to, info.value));
            }
        }
    }

    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    static void dfs(int x, long total) {
        visit[x] = true;

        if (second < total) {
            second = total;
            start = x;
        }

        for (Info info : field[x]) {
            if (visit[info.to]) continue;

            dfs(info.to, total + info.value);
        }

    }

    static void pro() {
        kruskal();

        dfs(0, 0);
        Arrays.fill(visit, false);

        dfs(start, 0);

        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}