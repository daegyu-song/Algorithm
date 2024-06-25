package dp;

import java.io.*;
import java.util.*;

public class BOJ2096 {
    static int N;
    static int[][] field;
    static int[][][] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= 2; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dy = new int [N + 1][3][2];
    }

    static void pro() {
        dy[1][0][0] = dy[1][0][1] = field[1][0];
        dy[1][1][0] = dy[1][1][1] = field[1][1];
        dy[1][2][0] = dy[1][2][1] = field[1][2];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 2; j++) {
                if (j == 0) {
                    dy[i][j][0] = Math.min(dy[i - 1][j][0] + field[i][j], dy[i - 1][j + 1][0] + field[i][j]);
                    dy[i][j][1] = Math.max(dy[i - 1][j][1] + field[i][j], dy[i - 1][j + 1][1] + field[i][j]);
                } else if (j == 1) {
                    dy[i][j][0] = Math.min(dy[i - 1][j][0] + field[i][j], Math.min(dy[i - 1][j + 1][0] + field[i][j], dy[i - 1][j - 1][0] + field[i][j]));
                    dy[i][j][1] = Math.max(dy[i - 1][j][1] + field[i][j], Math.max(dy[i - 1][j + 1][1] + field[i][j], dy[i - 1][j - 1][1] + field[i][j]));
                } else {
                    dy[i][j][0] = Math.min(dy[i - 1][j][0] + field[i][j], dy[i - 1][j - 1][0] + field[i][j]);
                    dy[i][j][1] = Math.max(dy[i - 1][j][1] + field[i][j], dy[i - 1][j - 1][1] + field[i][j]);
                }
            }
        }

        int ansMin = Math.min(dy[N][0][0], Math.min(dy[N][1][0], dy[N][2][0]));
        int ansMax = Math.max(dy[N][0][1], Math.max(dy[N][1][1], dy[N][2][1]));

        System.out.println(ansMax + " " + ansMin);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
