package dp;

import java.io.*;

public class BOJ1309 {
    static int N;
    static int MOD = 9901;
    static int[][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dy = new int[N + 1][3];

    }

    static void pro() {
        dy[1][0] = dy[1][1] = dy[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dy[i][0] = (dy[i - 1][0] + dy[i - 1][1] + dy[i - 1][2]) % MOD;
            dy[i][1] = (dy[i - 1][0] + dy[i - 1][2]) % MOD;
            dy[i][2] = (dy[i - 1][0] + dy[i - 1][1]) % MOD;
        }

        System.out.println((dy[N][0] + dy[N][1] + dy[N][2]) % MOD);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
