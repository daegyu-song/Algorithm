package dp;

import java.io.*;

public class BOJ15991 {
    static long[] dy;
    static int k = 1000000009;
    static StringBuilder sb = new StringBuilder();

    static void preprocess() {
        dy = new long[100001];
        dy[0] = 1;
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i < dy.length; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] + dy[i - 3]) % k;
        }
    }

    static void pro(int n) {
        long res = 0;
        for (int mid = 0; mid <= 3; mid++) {
            if (n - mid >= 0 && (n - mid) % 2 == 0){
                res += dy[(n - mid) / 2];
                res %= k;
            }
        }

        sb.append(res).append("\n");
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            pro(n);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        input();
    }
}
