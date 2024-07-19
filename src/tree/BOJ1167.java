package tree;

import java.io.*;
import java.util.*;

public class BOJ1167 {
    static class Info {
        int y, value;

        public Info(int y, int value) {
            this.y = y;
            this.value = value;
        }
    }

    static int v, ans, node;
    static ArrayList<Info>[] field;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        field = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while (true) {
                int y = Integer.parseInt(st.nextToken());
                if (y == -1) break;
                int c = Integer.parseInt(st.nextToken());
                field[x].add(new Info(y, c));
            }
        }
    }

    static void dfs(int start, int prev, int cost) {
        if (cost > ans) {
            ans = cost;
            node = start;
        }

        for (Info info : field[start]) {
            int y = info.y;
            int value = info.value;

            if (y == prev) continue;

            dfs(y, start, cost + value);
        }
    }

    static void pro() {
        dfs(1, -1, 0);

        dfs(node, -1, 0);

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
