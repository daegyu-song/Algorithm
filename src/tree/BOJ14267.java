package tree;

import java.util.*;
import java.io.*;

public class BOJ14267 {
    static int n, m;
    static ArrayList<Integer>[] tree;
    static int[] compliment;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (i == 1) continue;
            tree[x].add(i);
        }

        compliment = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            compliment[x] += y;
        }
    }

    static void dfs(int x) {

        for (int y : tree[x]) {
            compliment[y] += compliment[x];
            dfs(y);
        }
    }

    static void pro() {
        dfs(1);

        for (int i = 1; i <= n; i++) {
            sb.append(compliment[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
