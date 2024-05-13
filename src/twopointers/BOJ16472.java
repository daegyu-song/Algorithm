package twopointers;

import java.io.*;

public class BOJ16472 {
    static int N;
    static String alpha;
    static int[] alphaArr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        alpha = br.readLine();
        alphaArr = new int[26];
    }

    static void pro() {
        int right = -1, check = 0, ans = 0;
        for (int left = 0; left < alpha.length(); left++) {
            while (right + 1 < alpha.length() && (check < N || alphaArr[alpha.charAt(right + 1) - 97] > 0)) {
                right++;
                if (alphaArr[alpha.charAt(right) - 97] == 0) check++;
                alphaArr[alpha.charAt(right) - 97]++;
            }
            ans = Math.max(ans, right - left + 1);
            alphaArr[alpha.charAt(left) - 97]--;
            if (alphaArr[alpha.charAt(left) - 97] == 0) check--;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
