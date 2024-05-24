package tree;

import java.util.*;
import java.io.*;

public class BOJ3584 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, a, b;
    static ArrayList<Integer>[] field;
    static boolean[] visit;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[y].add(x);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
    }

    static void dfs(int x) {
        if (visit[x]) {
            System.out.println(x);
            return;
        }
        visit[x] = true;

        for (int y : field[x]) {
            dfs(y);
        }
    }

    static void pro() {
        dfs(a);
        dfs(b);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}
