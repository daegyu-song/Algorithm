package backtracking;

import java.io.*;
import java.util.*;

public class BOJ20167 {
    static int N, K, ans;
    static int[] food;


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        food = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            food[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void recur(int idx, int energy) {
        ans = Math.max(ans, energy);

        if (idx > N) return;

        int sum = 0;
        for (int i = idx; i <= N; i++) {
            sum += food[i];
            if (sum >= K) {
                // 먹고 넘기기
                recur(i + 1, energy + (sum - K));
                break;
            }
        }

        // 먹지 않고 넘기기
        recur(idx + 1, energy);
    }

    static void pro() {
        recur(1, 0);

        System.out.println(ans);
    }

    public static void main(String[] args)throws IOException {
        input();
        pro();
    }
}
