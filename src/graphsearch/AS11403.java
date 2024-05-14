package graphsearch;

import java.util.*;
import java.io.*;

public class AS11403 {
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

    static void bfs(int i) {
        Queue<Integer> que = new LinkedList<>();

        que.add(i);

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int k = 1; k <= N; k++) {
                if (visit[k]) continue;
                if (field[x][k] == 0) continue;

                que.add(k);
                visit[k] = true;
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            bfs(i);
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
