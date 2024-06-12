package dp;

import java.io.*;

public class BOJ15988 {
    static long[] dy;

    static void preprocess() {
        dy = new long[1000001];

        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i < dy.length; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] + dy[i - 3]) % 1000000009;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            System.out.println(dy[Integer.parseInt(br.readLine())]);
        }
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        input();
    }
}
