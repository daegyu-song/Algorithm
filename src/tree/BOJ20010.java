package tree;

import java.io.*;
import java.util.*;

public class BOJ20010 {
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

    static int n, k;
    static long first, second;
    static ArrayList<Info>[] field, field2;
    static boolean[] visit;
    static int startIdx;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        field = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            field[x].add(new Info(y, c));
            field[y].add(new Info(x, c));
        }

        field2 = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            field2[i] = new ArrayList<>();
        }

        visit = new boolean[n];
    }

    static void spanning(int start) {
        Queue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (visit[info.idx]) continue;

            first += info.weight;
            visit[info.idx] = true;

            for (Info i : field[info.idx]) {
                if (visit[i.idx]) continue;
                pq.add(i);
            }
        }
    }

    public static void dfs(int idx, int total) {
        visit[idx] = true;

        if(second < total) {
            second = total;
            startIdx = idx;
        }

        for (Info info : field[idx]) {
            if (visit[info.idx]) continue;
            dfs(info.idx, total + info.weight);
        }
    }

    static void pro() {
        spanning(0);
        Arrays.fill(visit, false);

        dfs(0, 0);
        Arrays.fill(visit, false);

        dfs(startIdx, 0);

        System.out.println(first);
        System.out.println(second);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
