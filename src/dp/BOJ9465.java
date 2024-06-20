package dp;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    static int N;
    static int[][] sticker, dy;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        sticker = new int[2][N + 1];
        dy = new int[2][N + 1];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sticker[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        dy[0][1] = sticker[0][1];
        dy[1][1] = sticker[1][1];

        for (int i = 2; i <= N; i++) {
            dy[0][i] = Math.max(dy[1][i - 1] + sticker[0][i], dy[1][i - 2] + sticker[0][i]);
            dy[1][i] = Math.max(dy[0][i - 1] + sticker[1][i], dy[0][i - 2] + sticker[1][i]);
        }

        System.out.println(Math.max(dy[0][N], dy[1][N]));
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}

