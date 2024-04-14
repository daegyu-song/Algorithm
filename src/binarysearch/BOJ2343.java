package binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2343 {
    static int N, M;
    static int[] videos;

    static boolean test(int blu) {
        int cnt = 1;
        int sum = videos[0];
        for (int i = 1; i < videos.length; i++) {
            if (sum + videos[i] > blu) {
                cnt++;
                sum = videos[i];
            } else {
                sum += videos[i];
            }
        }
        return cnt <= M;
    }

    static void process() {
        int L = 0, R = 10000 * N / M, ans = 0;
        for (int i = 0; i < videos.length; i++) L = Math.max(L, videos[i]);
        while (L <= R) {
            int blu = (L + R) / 2;
            if (test(blu)) {
                ans = blu;
                R = blu - 1;
            } else {
                L = blu + 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        videos = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < videos.length; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
        }
        process();
    }
}
