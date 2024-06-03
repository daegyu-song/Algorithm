package topologicalsort;

import java.util.*;
import java.io.*;

public class BOJ1005 {
    static int N, K, ans;
    static ArrayList<Integer>[] field;
    static int[] buildTime, minTime, indeg;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        buildTime = new int[N + 1];
        minTime = new int[N + 1];
        indeg = new int[N + 1];
        field = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            buildTime[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            field[x].add(y);
            indeg[y]++;
        }

        ans = Integer.parseInt(br.readLine());
    }

    static void pro() {
        Deque<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                minTime[i] = buildTime[i];
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {
                indeg[y]--;

                minTime[y] = Math.max(buildTime[y] + minTime[x], minTime[y]);
                if (indeg[y] == 0) {
                    que.add(y);
                }
            }
        }

        System.out.println(minTime[ans]);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}
