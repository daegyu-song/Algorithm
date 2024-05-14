package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ11403 {
    static int N;
    static int[][] field;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[N + 1];
    }

    static void dfs(int i) {
        for (int k = 1; k <= N; k++) {
            if (visit[k]) continue;
            if (field[i][k] == 0) continue;

            visit[k] = true;
            dfs(k);
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            dfs(i);
            for (int k = 1; k <= N; k++) {
                sb.append(visit[k] ? 1 : 0).append(" ");
            }
            sb.append("\n");
            Arrays.fill(visit, false);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
