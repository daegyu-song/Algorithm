package dp;

import java.io.*;
import java.util.*;

public class BOJ1495 {
    static int N, S, M;
    static int[][] dy;
    static int[] musics;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        musics = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            musics[i] = Integer.parseInt(st.nextToken());
        }

        dy = new int[N + 1][M + 1];
    }

    static void pro() {
        dy[0][S] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dy[i - 1][j] > 0) {
                    for (int k : new int[]{j - musics[i], j + musics[i]}) {
                        if (k < 0 || k > M) continue;
                        dy[i][k] = 1;
                    }
                }
            }
        }

        for (int i = dy[N].length - 1; i >= 0; i--) {
            if (dy[N][i] > 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
