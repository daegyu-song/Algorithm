package dp;

import java.io.*;
import java.util.Arrays;

public class BOJ11057 {
    static int N;
    static final int MOD = 10007;
    static int[][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dy = new int[N + 1][10];
    }

    static void pro() {
        Arrays.fill(dy[1], 1);

        for (int i = 2; i <= N; i++) {
            dy[i][0] = 1;

            for (int j = 1; j <= 9; j++) {
                dy[i][j] = (dy[i][j - 1] + dy[i - 1][j]) % MOD;
            }
        }

        int ans = 0;
        for (int i : dy[N]) ans += i;
        System.out.println(ans % MOD);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
