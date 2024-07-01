package dp;

import java.io.*;
import java.util.*;

public class BOJ10942 {
    static int N, M;
    static int[] numbers;
    static int[][] dy;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dy = new int[N + 1][N + 1];

        for (int len = 1; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = len + i - 1;

                if (i == j) dy[i][j] = 1;
                else if (j - i == 1) dy[i][j] = numbers[i] == numbers[j] ? 1 : 0;
                else dy[i][j] = (numbers[i] == numbers[j] && dy[i + 1][j - 1] == 1) ? 1 : 0;
            }
        }
    }

    static void pro() throws IOException{
        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(dy[x][y]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
