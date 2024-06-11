package dp;

import java.io.*;

public class BOJ1003 {
    static int[][] dy;

    static void preprocess() {
        dy = new int[41][2];
        dy[0][0] = 1;
        dy[1][1] = 1;

        for (int i = 2; i < dy.length; i++) {
            dy[i][0] = dy[i - 1][0] + dy[i - 2][0];
            dy[i][1] = dy[i - 1][1] + dy[i - 2][1];
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dy[n][0] + " " + dy[n][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        input();
    }
}
