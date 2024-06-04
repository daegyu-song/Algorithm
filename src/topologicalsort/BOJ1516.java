package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ1516 {
    static int N;
    static ArrayList<Integer>[] field;
    static int[] buildTime, ans, indeg;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        buildTime = new int[N + 1];
        ans = new int[N + 1];
        indeg = new int[N + 1];

        field = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                field[x].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                ans[i] = buildTime[i];
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {

                indeg[y]--;
                ans[y] = Math.max(buildTime[y] + ans[x], ans[y]);
                if (indeg[y] == 0) {
                    que.add(y);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
