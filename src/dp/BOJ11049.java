package dp;

import java.io.*;
import java.util.*;

public class BOJ11049 {
    static int N;
    static int[][] dy, matrix;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        dy = new int[N + 1][N + 1];
    }

    static void pro() {

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = len + i - 1;
                dy[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dy[i][j] = Math.min(dy[i][j], dy[i][k] + dy[k + 1][j] + matrix[i][0] * matrix[k + 1][0] * matrix[j][1]);
                }
            }
        }

        System.out.println(dy[1][N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
