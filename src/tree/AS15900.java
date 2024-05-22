package tree;

import java.util.*;
import java.io.*;

public class AS15900 {
    static int N, ans;
    static ArrayList<Integer>[] field;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }
    }

    static void dfs(int x, int prev, int depth) {
        if (x != 1 && field[x].size() == 1) ans += depth;

        for (int y : field[x]) {
            // visit 배열의 다른 방법
            if (y == prev) continue;
            dfs(y, x, depth + 1);
        }
    }

    static void pro() {
        dfs(1, -1, 0);

        System.out.println(ans % 2 != 0 ? "Yes" : "No");
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
