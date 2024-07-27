package tree;

import java.io.*;
import java.util.*;

public class BOJ1197 {

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

    static int v, e, ans;
    static ArrayList<Info>[] field;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        field = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            field[x].add(new Info(y, c));
            field[y].add(new Info(x, c));
        }

        visit = new boolean[v + 1];
    }

    static void spanning(int start) {
        Queue<Info> queue = new PriorityQueue<>();
        queue.add(new Info(start, 0));

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (visit[info.idx]) continue;

            visit[info.idx] = true;
            ans += info.weight;

            for (Info next : field[info.idx]) {
                if(visit[next.idx]) continue;
                queue.add(next);
            }
        }
    }

    static void pro() {

        spanning(1);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
