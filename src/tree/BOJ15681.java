package tree;

import java.util.*;
import java.io.*;

public class BOJ15681 {
    static int vertex, root, query;
    static ArrayList<Integer>[] tree;
    static int[] cnt;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        query = Integer.parseInt(st.nextToken());

        tree = new ArrayList[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < vertex; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }

        cnt = new int[vertex + 1];
        Arrays.fill(cnt, 1);

        visit = new boolean[vertex + 1];
    }

    static void dfs(int x) {
        visit[x] = true;

        for (int y : tree[x]) {
            if (visit[y]) continue;

            dfs(y);
            cnt[x] += cnt[y];
        }
    }

    static void pro() throws IOException {
        dfs(root);
        for (int i = 0; i < query; i++) {
            System.out.println(cnt[Integer.parseInt(br.readLine())]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
