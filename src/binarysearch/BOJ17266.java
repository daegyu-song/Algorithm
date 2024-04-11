package binarysearch;

import java.util.*;
import java.io.*;

public class BOJ17266 {
    static int N, M;
    static int[] streetLight;

    static boolean test(int mid) {
       int prev = 0;
       for (int i = 0; i < streetLight.length; i++) {
           if (streetLight[i] - mid <= prev) {
               prev = streetLight[i] + mid;
           } else {
               return false;
           }
       }
       return N - prev <= 0;
    }

    static void process() {
        int L = 1, R = N, height = 0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (test(mid)) {
                height = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(height);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        streetLight = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < streetLight.length; i++) {
            streetLight[i] = Integer.parseInt(st.nextToken());
        }
        process();
    }
}
