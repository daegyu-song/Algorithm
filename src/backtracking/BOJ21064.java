package backtracking;

import java.io.*;

public class BOJ21064 {
    static int N;
    static int ansMax, ansMin;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static int oddCnt(int x) {
        int res = 0;

        while (x > 0) {
            int digit = x % 10;
            if (digit % 2 != 0) res++;
            x /= 10;
        }

        return res;
    }

    static void recur(int x, int totalCnt) {

        if (x <= 9) {
            ansMin = Math.min(ansMin, totalCnt);
            ansMax = Math.max(ansMax, totalCnt);
            return;
        }

        if (x <= 99) {
            int nx = (x / 10) + (x % 10);
            recur(nx, totalCnt + oddCnt(nx));
            return;
        }

        String str = Integer.toString(x);
        for (int i = 0; i <= str.length() - 3; i++) {
            for (int j = i + 1; j <= str.length() - 2; j++) {
                String x1 = str.substring(0, i + 1);
                String x2 = str.substring(i + 1, j + 1);
                String x3 = str.substring(j + 1);

                int nx = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
                recur(nx, totalCnt + oddCnt(nx));
            }
        }
    }

    static void pro() {
        ansMax = 0;
        ansMin = Integer.MAX_VALUE;

        recur(N, oddCnt(N));
        System.out.println(ansMin + " " + ansMax);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
