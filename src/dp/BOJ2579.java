package dp;

import java.io.*;

public class BOJ2579 {
    static int[] A;
    static int[][] dy;
    static int n;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dy = new int[n + 1][2];
        dy[1][0] = A[1];
    }

    static void pro() {
        for (int i = 2; i <= n; i++) {
            dy[i][0] = Math.max(dy[i - 2][0] + A[i], dy[i - 2][1] + A[i]);
            dy[i][1] = dy[i - 1][0] + A[i];
        }

        System.out.println(Math.max(dy[n][0], dy[n][1]));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
