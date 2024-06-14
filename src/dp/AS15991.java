package dp;

import java.io.*;

public class AS15991 {
    static long[] dy;
    static StringBuilder sb = new StringBuilder();

    static void preprocess() {
        dy = new long[100001];
        dy[0] = 1;
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 2;
        dy[4] = 3;
        dy[5] = 3;

        for (int i = 6; i < dy.length; i++) {
            dy[i] = (dy[i - 2] + dy[i - 4] + dy[i - 6]) % 1000000009;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dy[n]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        input();
    }
}
