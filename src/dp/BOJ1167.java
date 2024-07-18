package dp;

import java.util.*;
import java.io.*;

public class BOJ1167 {
    static class Info {
        int y, value;

        public Info(int y, int value) {
            this.y = y;
            this.value = value;
        }
    }

    static int v, ans;
    static ArrayList<Info>[] field;
    static int[] dp;

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

        dp = new int[v + 1];
    }

    static void dfs(int start, int prev) {

        for (Info info : field[start]) {

            int y = info.y;
            int value = info.value;

            if (y == prev) continue;

            dfs(y, start);
            dp[start] = Math.max(dp[y] + value, dp[start]);
        }
    }

    static void pro() {

        dfs(1, -1);

        for (int i : dp) {
            ans = Math.max(ans, i);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
