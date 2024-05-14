package graphsearch;

import java.util.*;
import java.io.*;

public class BOJ11724 {
    static int N, M;
    static ArrayList<Integer>[] nums;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            nums[x].add(y);
            nums[y].add(x);
        }
    }

    static void dfs(int i) {
        visit[i] = true;

        for (int j : nums[i]) {
            if (visit[j]) continue;
            dfs(j);
        }
    }

    static void pro() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            cnt++;
            dfs(i);
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}