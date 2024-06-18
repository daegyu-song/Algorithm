package dp;

import java.io.*;

public class BOJ2156 {
    static int N;
    static int[] wine;
    static int[][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        wine = new int[N + 1];
        dy = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
    }

    static void pro() {
        dy[1][0] = wine[1];

        if (N >= 2) {
            dy[2][0] = wine[2];
            dy[2][1] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            dy[i][0] = Math.max(dy[i - 2][0] + wine[i], dy[i - 2][1] + wine[i]);
            dy[i][0] = Math.max(dy[i][0], Math.max(dy[i - 3][0] + wine[i], dy[i - 3][1] + wine[i]));
            dy[i][1] = dy[i - 1][0] + wine[i];
        }

        System.out.println(Math.max(Math.max(dy[N][0], dy[N][1]), Math.max(dy[N - 1][0], dy[N - 1][1])));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
