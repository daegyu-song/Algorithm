package dp;

import java.util.*;
import java.io.*;

public class BOJ1509 {
    static String str;
    static int strLen;
    static int[] dy;
    static boolean[][] palindrome;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = "S" + br.readLine();
        strLen = str.length() - 1;

        dy = new int[strLen + 1];
        palindrome = new boolean[strLen + 1][strLen + 1];

        for (int i = 1; i <= strLen; i++) {
            dy[i] = Integer.MAX_VALUE;
        }
    }

    static void preprocess() {
        for (int len = 1; len <= strLen; len++) {
            for (int i = 1; i <= strLen - len + 1; i++) {
                int j = len + i - 1;

                if (i == j) palindrome[i][j] = true;
                else if (j - i == 1) palindrome[i][j] = str.charAt(i) == str.charAt(j);
                else palindrome[i][j] = str.charAt(i) == str.charAt(j) && palindrome[i + 1][j - 1];
            }
        }
    }

    static void pro() {
        preprocess();

        for (int i = 1; i <= strLen; i++) {
            for (int j = 1; j <= i; j++) {
                if (palindrome[j][i]) {
                    dy[i] = Math.min(dy[i], dy[j - 1] + 1);
                }
            }
        }
        System.out.println(dy[strLen]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
