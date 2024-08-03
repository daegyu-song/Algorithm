package graphsearch;

import java.io.*;
import java.util.*;

public class BOJ17471 {
    static int n, count, first, second, ans, total;
    static int[] peoples;
    static ArrayList<Integer>[] field;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        peoples = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        field = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            field[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= k; j++) {
                field[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        visit = new boolean[n + 1];

        ans = Integer.MAX_VALUE;
    }

    static void dfs(int start) {
        count++;
        visit[start] = true;
        total += peoples[start];

        for (int y : field[start]) {

            if (visit[y]) continue;

            dfs(y);
        }
    }

    static void pro() {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                visit[i] = true;
                visit[j] = true;

                dfs(i);
                first = total;
                total = 0;

                dfs(j);
                second = total;
                total = 0;

                if (count == n) ans = Math.min(ans, Math.abs(first - second));
            }

            count = 0;
            first = 0;
            second = 0;
            Arrays.fill(visit, false);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
