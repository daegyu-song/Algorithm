package dp;

import java.io.*;

public class BOJ11726 {
    static int[] dy;

    static void preprocess() {
        dy = new int[1001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 3;

        for (int i = 4; i < dy.length; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2]) % 10007;
        }
    }

    static void pro() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(dy[Integer.parseInt(br.readLine())]);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        pro();
    }
}
