package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ11725 {
    static int N;
    static ArrayList<Integer>[] field;
    static boolean[] visit;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) field[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            field[y].add(x);
        }
        visit = new boolean[N + 1];
        ans = new int[N + 1];
    }

    static void dfs(int start) {
        visit[start] = true;

        for (int i : field[start]) {
            if (!visit[i]) {
                ans[i] = start;
                dfs(i);
            }
        }
    }

    static void pro() {
        dfs(1);

        for (int i = 2; i <= N; i++) sb.append(ans[i]).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
