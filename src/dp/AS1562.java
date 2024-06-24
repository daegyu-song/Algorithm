package dp;

import java.io.*;

public class AS1562 {
    static int N;
    static final int MOD = 1000000000;
    static int[][][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new int[N + 1][10][1 << 10];
    }

    static void pro() {
        for (int i = 1; i < 10; i++) {
            dy[1][i][1 << i] = 1;
        }
        for (int i = 2; i< N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    int bit = k | (1 << j);
                    if (j == 0) {
                        dy[i][j][bit] = (dy[i][j][bit] + dy[i - 1][j + 1][k]) % MOD;
                    }
                    else if (j == 9) {
                        dy[i][j][bit] = (dy[i][j][bit] + dy[i - 1][j - 1][k]) % MOD;
                    }
                    else {
                        dy[i][j][bit] = (dy[i][j][bit] + dy[i -1 ][j + 1][k]+ dy[i - 1][j - 1][k]) % MOD;
                    }
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; i++) {
            sum = (sum + dy[N][i][1023]) % MOD;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}