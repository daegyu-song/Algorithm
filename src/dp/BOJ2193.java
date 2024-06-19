package dp;

import java.io.*;

public class BOJ2193 {
    static int N;
    static long[][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new long[N + 1][2];
    }

    static void pro() {
        dy[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            dy[i][0] = dy[i - 1][0] + dy[i - 1][1];
            dy[i][1] = dy[i - 1][0];
        }

        System.out.println(dy[N][0] + dy[N][1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}
