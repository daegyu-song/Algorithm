package dp;

import java.io.*;
import java.util.*;

public class BOJ5557 {
    static int N;
    static int[] field;
    static long[][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            field[i] = Integer.parseInt(st.nextToken());
        }
        dy = new long[N][21];
    }

    static void pro() {
        dy[1][field[1]] = 1;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k : new int[]{j - field[i], j + field[i]}) {
                    if (k > 20 || k < 0) continue;
                    dy[i][k] += dy[i - 1][j];
                }
            }
        }
        System.out.println(dy[N - 1][field[N]]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
