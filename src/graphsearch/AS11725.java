package graphsearch;

import java.util.*;
import java.io.*;

public class AS11725 {
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

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            int x = que.poll();

            for (int y : field[x]) {
                if (!visit[y]) {
                    que.add(y);
                    ans[y] = x;
                    visit[y] = true;
                }
            }
        }

    }

    static void pro() {
        bfs(1);

        for (int i = 2; i <= N; i++) sb.append(ans[i]).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
