package dp;

import java.io.*;
import java.util.*;

public class BOJ2688 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[][] dy;

    static void preprocess() {
        dy = new long[65][10];

        Arrays.fill(dy[1], 1);

        for (int i = 2; i <= 64; i++) {
            dy[i][0] = dy[i - 1][0];
            for (int j = 1; j <= 9; j++) {
                dy[i][j] = dy[i][j - 1] + dy[i - 1][j];
            }
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() {
        long ans = 0;
        for (int i = 0; i <= 9; i++) ans += dy[N][i];
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
