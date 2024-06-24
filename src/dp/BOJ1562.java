package dp;

import java.io.*;

public class BOJ1562 {
    static int N;
    static final int MOD = 1000000000;
    static int[][][][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new int[N + 1][10][10][10];
    }

    static void pro() {
        for (int num = 1; num <= 9; num++) {
            dy[1][num][num][num] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int prev = 0; prev <= 9; prev++) {
                for (int low = 0; low <= 9; low++) {
                    for (int high = 0; high <= 9; high++) {
                        for (int cur : new int[]{prev - 1, prev + 1}) {
                            if (cur < 0 || cur > 9) continue;
                            dy[len][cur][Math.min(low, cur)][Math.max(high, cur)] += dy[len - 1][prev][low][high];
                            dy[len][cur][Math.min(low, cur)][Math.max(high, cur)] %= MOD;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int num = 0; num <= 9; num++) {
            ans += dy[N][num][0][9];
            ans %= MOD;
        }

        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
