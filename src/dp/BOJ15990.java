package dp;

import java.io.*;
import java.util.Arrays;

public class BOJ15990 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dy;
    static final int MOD = 1000000009;

    static void preprocess() {
        dy = new long[100001][4];
        dy[1][1] = 1;
        dy[2][2] = 1;
        dy[3][1] = 1;
        dy[3][2] = 1;
        dy[3][3] = 1;

        for (int i = 4; i < dy.length; i++) {
            dy[i][1] = (dy[i - 1][2] + dy[i - 1][3]) % MOD;
            dy[i][2] = (dy[i - 2][1] + dy[i - 2][3]) % MOD;
            dy[i][3] = (dy[i - 3][1] + dy[i - 3][2]) % MOD;
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() {
        long ans = (dy[N][1] + dy[N][2] + dy[N][3]) % MOD;
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            input();
            pro();
        }
    }
}
