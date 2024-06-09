package dp;

import java.io.*;

public class BOJ9095 {
    static int[] dy;
    static StringBuilder sb = new StringBuilder();

    static void preprocess() {
        dy = new int[12];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i < dy.length; i++) {
            dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append(dy[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        input();
    }
}
