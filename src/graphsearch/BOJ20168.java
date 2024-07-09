package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ20168 {

    static class Node {
        int next;
        int money;

        public Node(int next, int money) {
            this.next = next;
            this.money = money;
        }
    }

    static int n, m, start, end, c, ans;
    static boolean[] visit;
    static ArrayList<Node>[] field;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        field = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

            field[x].add(new Node(y, m));
            field[y].add(new Node(x, m));
        }

        ans = Integer.MAX_VALUE;

        visit = new boolean[n + 1];
    }

    static void dfs(int x, int currentMoney, int maxMoney) {
        visit[x] = true;

        if (x == end) {
            ans = Math.min(ans, maxMoney);
            return;
        }

        for (Node node : field[x]) {

            if (visit[node.next]) continue;
            if (currentMoney < node.money) continue;


            dfs(node.next, currentMoney - node.money, Math.max(maxMoney, node.money));
            visit[node.next] = false;
        }
    }

    static void pro() {
        dfs(start, c, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
