package twopointers;

import java.io.*;

public class AS16472 {
    static int N, check;
    static String alpha;
    static int[] alphaArr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        alpha = br.readLine();
        alphaArr = new int[26];
    }

    static void add(int x) {
        alphaArr[x - 'a']++;
        if (alphaArr[x - 'a'] == 1) check++;
    }

    static void remove(int x) {
        alphaArr[x - 'a']--;
        if (alphaArr[x - 'a'] == 0) check--;
    }

    static void pro() {
        int ans = 0;
        for (int left = 0, right = 0; right < alpha.length(); right++) {
            add(alpha.charAt(right));
            while (check > N) {
                remove(alpha.charAt(left++));
            }
            ans = Math.max(ans, right - left + 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
