package dp;

import java.io.*;

public class BOJ2011 {
    static String str;
    static int N;
    static int[] dy;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = str.length();
    }

    static boolean check(char A, char B) {
        if (A == '0') return false;
        if (A == '1') return true;
        if (A >= '3') return false;
        return B <= '6';
    }

    static void pro() {
        dy = new int[N];

        if (str.charAt(0) != '0') dy[0] = 1;

        for (int i = 1; i < N; i++) {
            if (str.charAt(i) != '0') dy[i] = dy[i - 1];

            if (check(str.charAt(i - 1), str.charAt(i))) {
                if (i >= 2) dy[i] += dy[i - 2];
                else dy[i] += 1;
                dy[i] %= 1000000;
            }
        }

        System.out.println(dy[N - 1]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
